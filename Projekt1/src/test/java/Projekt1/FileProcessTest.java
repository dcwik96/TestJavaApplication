package Projekt1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileProcessTest {

    private FileProcess fileProcess;

    @BeforeEach
    public void setUp() {
        String filePath = "playerdb.txt";
        fileProcess = new FileProcess(filePath);
    }

    @Test
    public void checkIfReadFromFileThrowsExceptionWhenFileNotFound() {
        FileProcess fileProcess = new FileProcess("TenPlikNaPewnoNieIstnieje.txt");
        assertThrows(FileNotFoundException.class, () -> fileProcess.readFromFile());
    }

    @Test
    public void checkIfReadFromFileReturnFileDataAsArrayListOfArrayOfString() throws IOException {
        String name = "nazwa";
        int wins = 0, loses = 0;
        Player p = new Player(name, wins, loses);

        fileProcess.saveToFileWholePlayer(p);
        ArrayList<String[]> actualArrayList = fileProcess.readFromFile();

        assertEquals(name, actualArrayList.get(actualArrayList.size() - 1)[0]);
        assertEquals(wins, Integer.parseInt(actualArrayList.get(actualArrayList.size() - 1)[1]));
        assertEquals(loses, Integer.parseInt(actualArrayList.get(actualArrayList.size() - 1)[2]));
    }

    @Test
    public void checkIfSaveToFileWholePlayerWorksProperly() throws IOException {
        String name = "nazwaa";
        int wins = 1, loses = 2;
        Player p = new Player(name, wins, loses);

        fileProcess.saveToFileWholePlayer(p);
        ArrayList<String> actualArrayList = readLineFromFile();
        String expectedString = name + "," + wins + "," + loses;
        assertEquals(expectedString, actualArrayList.get(actualArrayList.size() - 1));
    }

    @Test
    public void checkIfSaveToFileWholePlayerDontRepeat() throws IOException {
        String name = "nazwaa";
        int wins = 1, loses = 2;
        Player p = new Player(name, wins, loses);

        fileProcess.saveToFileWholePlayer(p);
        fileProcess.saveToFileWholePlayer(p);
        ArrayList<String[]> actualArrayList = fileProcess.readFromFile();
        assertEquals(1, actualArrayList.size());
    }

    public ArrayList<String> readLineFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("playerdb.txt"));
        String line;
        ArrayList<String> lines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    @Test
    public void checkIfFindPlayerInDBReturnIndexWhenFound() throws IOException {
        String name = "poszukiwany";
        int wins = 10, loses = 20;
        Player p = new Player(name, wins, loses);

        fileProcess.saveToFileWholePlayer(p);
        ArrayList<String> actualArrayList = readLineFromFile();

        assertThat(fileProcess.findPlayerInDB(name), is(actualArrayList.size() - 1));
    }

    @Test
    public void checkIfFindPlayerInDBReturnNegativeValueWhenNotFound() throws IOException {
        assertEquals(-1, fileProcess.findPlayerInDB("TakiejNazwyUzytkownikaNaPewnoNieMa"));
    }

    @Test
    public void checkIfUpdatePlayerStatisticsWorksProperly() throws IOException {
        Player p = new Player("asdf", 2, 0);
        fileProcess.saveToFileWholePlayer(p);
        fileProcess.updatePlayerStatistics("asdf", 1, 0);
        ArrayList<String[]> actualArrayList = fileProcess.readFromFile();


        assertEquals(1, actualArrayList.size());
        assertEquals("3", actualArrayList.get(0)[1]);
    }

    @Test
    public void checkIfPrintStatisticsWorksProperly() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Player p = new Player("asdf", 2, 0);
        Player p2 = new Player("asdff", 1, 1);
        fileProcess.saveToFileWholePlayer(p);
        fileProcess.saveToFileWholePlayer(p2);

        fileProcess.printStatistics();

        assertThat(outputStream.toString(), equalToIgnoringWhiteSpace("NAME WINS LOSES asdf 2 0 asdff 1 1"));
        System.setOut(System.out);
    }

    @Test
    public void checkIfPrintStatisticsWhenDBIsEmpty() throws IOException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        fileProcess.printStatistics();

        assertEquals("NAME\tWINS\tLOSES\n", outputStream.toString());
        System.setOut(System.out);
    }

    @AfterEach
    public void dropDb() throws IOException {
        fileProcess.dropDataBase();
    }
}
