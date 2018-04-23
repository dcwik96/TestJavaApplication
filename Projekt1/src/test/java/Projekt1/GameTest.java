package Projekt1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private FlashCard flashCard;

    @BeforeEach
    public void setUp() {
        flashCard = new FlashCard();
        game = new Game();
    }

    @Test
    public void checkIfRulesArePrintedCorrectly() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        game.printRules();

        verify(out).println(startsWith("Celem"));
    }

    @Test
    public void checkIfAskForNamesDefinesPlayerNameCorrectly() {
        Game mockedGame = mock(Game.class);
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        doNothing().when(out).println();
        when(mockedGame.read()).thenReturn("Gracz1").thenReturn("Gracz2");
        doCallRealMethod().when(mockedGame).askForNames();
        doCallRealMethod().when(mockedGame).getPlayer1();
        doCallRealMethod().when(mockedGame).getPlayer2();

        mockedGame.askForNames();
        String actualPlayerOneName = mockedGame.getPlayer1();
        String actualPlayerTwoName = mockedGame.getPlayer2();

        verify(mockedGame, times(2)).read();
        assertThat(actualPlayerOneName).startsWith("Gracz").endsWith("1").isEqualToIgnoringCase("gracz1");
        assertThat(actualPlayerTwoName).startsWith("Gracz").endsWith("2").isEqualToIgnoringCase("gracz2");
    }

    @Test
    public void checkIfSaveNewLooserPlayerWorksForOne() throws IOException {
        game.saveNewLooserPlayer(1);
        FileProcess f = new FileProcess("playerdb.txt");
        ArrayList<String[]> db = f.readFromFile();

        assertEquals("0", db.get(0)[1]);
        assertEquals("1", db.get(0)[2]);
    }

    @Test
    public void checkIfSaveNewLooserPlayerWorksForTwo() throws IOException {
        game.saveNewLooserPlayer(2);
        FileProcess f = new FileProcess("playerdb.txt");
        ArrayList<String[]> db = f.readFromFile();

        assertEquals("0", db.get(0)[1]);
        assertEquals("1", db.get(0)[2]);
    }

    @Test
    public void checkIfSaveNewLooserPlayerThrowsExWhenBadArgument() {
        assertThrows(IllegalArgumentException.class, () -> game.saveNewLooserPlayer(3));
    }


    @Test
    public void checkIfSaveNewWinnerPlayerWorksForOne() throws IOException {
        game.saveNewWinnerPlayer(1);
        FileProcess f = new FileProcess("playerdb.txt");
        ArrayList<String[]> db = f.readFromFile();

        assertEquals("0", db.get(0)[2]);
        assertEquals("1", db.get(0)[1]);
    }

    @Test
    public void checkIfSaveNewWinnerPlayerWorksForTwo() throws IOException {
        game.saveNewWinnerPlayer(2);
        FileProcess f = new FileProcess("playerdb.txt");
        ArrayList<String[]> db = f.readFromFile();

        assertEquals("0", db.get(0)[2]);
        assertEquals("1", db.get(0)[1]);
    }

    @Test
    public void checkIfSaveNewWinnerPlayerThrowsExWhenBadArgument() {
        assertThrows(IllegalArgumentException.class, () -> game.saveNewWinnerPlayer(3));
    }


    @Test
    public void checkIfRunDoNothingWhenDecisionIsZero() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockFileProcess = mock(FileProcess.class);

        doNothing().when(mockFileProcess).printStatistics();

        when(mockedGame.read()).thenReturn("0");
        doCallRealMethod().when(mockedGame).run();
        doNothing().when(mockedGame).play();
        doCallRealMethod().when(mockedGame).setFileProcess(mockFileProcess);

        mockedGame.setFileProcess(mockFileProcess);
        mockedGame.run();

        verify(mockFileProcess, never()).printStatistics();
        verify(mockedGame, never()).play();
    }

    @Test
    public void checkIfRunExecutesPlayMethodWhenDecisionIsOne() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockFileProcess = mock(FileProcess.class);

        doNothing().when(mockFileProcess).printStatistics();

        when(mockedGame.read()).thenReturn("1").thenReturn("0");
        doCallRealMethod().when(mockedGame).run();
        doNothing().when(mockedGame).play();
        doCallRealMethod().when(mockedGame).setFileProcess(mockFileProcess);

        mockedGame.setFileProcess(mockFileProcess);
        mockedGame.run();

        verify(mockFileProcess, never()).printStatistics();
        verify(mockedGame).play();
    }

    @Test
    public void checkIfRunExecutesPrintStatisticsWhenDecisionISTwo() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockFileProcess = mock(FileProcess.class);

        doNothing().when(mockFileProcess).printStatistics();

        when(mockedGame.read()).thenReturn("2").thenReturn("0");
        doCallRealMethod().when(mockedGame).run();
        doNothing().when(mockedGame).play();
        doCallRealMethod().when(mockedGame).setFileProcess(mockFileProcess);

        mockedGame.setFileProcess(mockFileProcess);
        mockedGame.run();

        verify(mockFileProcess).printStatistics();
        verify(mockedGame, never()).play();
    }

    @Test
    public void checkIfNewPlayerOneWinMethodWorksProperly() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockedFileProcess = mock(FileProcess.class);

        doCallRealMethod().when(mockedGame).play();
        when(mockedGame.read()).thenReturn("1").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("1");
        when(mockedFileProcess.findPlayerInDB(anyString())).thenReturn(-1);
        doNothing().when(mockedGame).saveNewWinnerPlayer(1);
        doNothing().when(mockedGame).saveNewLooserPlayer(2);
        doCallRealMethod().when(mockedGame).setPlayer1(anyString());
        doCallRealMethod().when(mockedGame).setPlayer2(anyString());
        doCallRealMethod().when(mockedGame).setFileProcess(mockedFileProcess);

        mockedGame.setFileProcess(mockedFileProcess);
        mockedGame.setPlayer1("asdf");
        mockedGame.setPlayer2("asdff");
        mockedGame.play();

        verify(mockedGame).saveNewLooserPlayer(2);
        verify(mockedGame).saveNewWinnerPlayer(1);
    }

    @Test
    public void checkIfNewPlayerTwoWinMethodWorksProperly() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockedFileProcess = mock(FileProcess.class);

        doCallRealMethod().when(mockedGame).play();
        when(mockedGame.read()).thenReturn("1").thenReturn("2").thenReturn("3").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("4").thenReturn("2");
        when(mockedFileProcess.findPlayerInDB(anyString())).thenReturn(-1);
        doNothing().when(mockedGame).saveNewWinnerPlayer(2);
        doNothing().when(mockedGame).saveNewLooserPlayer(1);
        doCallRealMethod().when(mockedGame).setPlayer1(anyString());
        doCallRealMethod().when(mockedGame).setPlayer2(anyString());
        doCallRealMethod().when(mockedGame).setFileProcess(mockedFileProcess);

        mockedGame.setFileProcess(mockedFileProcess);
        mockedGame.setPlayer1("asdf");
        mockedGame.setPlayer2("asdff");
        mockedGame.play();

        verify(mockedGame).saveNewLooserPlayer(1);
        verify(mockedGame).saveNewWinnerPlayer(2);
    }


    @Test
    public void checkIfOldPlayerTwoWinMethodWorksProperly() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockedFileProcess = mock(FileProcess.class);

        doCallRealMethod().when(mockedGame).play();
        when(mockedGame.read()).thenReturn("1").thenReturn("2").thenReturn("3").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("4").thenReturn("2");
        when(mockedFileProcess.findPlayerInDB(anyString())).thenReturn(1);
        doNothing().when(mockedFileProcess).updatePlayerStatistics(anyString(), anyInt(), anyInt());
        doCallRealMethod().when(mockedGame).setPlayer1(anyString());
        doCallRealMethod().when(mockedGame).setPlayer2(anyString());
        doCallRealMethod().when(mockedGame).setFileProcess(mockedFileProcess);

        mockedGame.setFileProcess(mockedFileProcess);
        mockedGame.setPlayer1("asdf");
        mockedGame.setPlayer2("asdff");
        mockedGame.play();

        verify(mockedFileProcess).updatePlayerStatistics("asdf", 0, 1);
        verify(mockedFileProcess).updatePlayerStatistics("asdff", 1, 0);
    }

    @Test
    public void checkIfOldPlayerOneWinMethodWorksProperly() throws IOException {
        Game mockedGame = mock(Game.class);
        FileProcess mockedFileProcess = mock(FileProcess.class);

        doCallRealMethod().when(mockedGame).play();
        when(mockedGame.read()).thenReturn("1").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("1").thenReturn("2").thenReturn("1");
        when(mockedFileProcess.findPlayerInDB(anyString())).thenReturn(1);
        doNothing().when(mockedFileProcess).updatePlayerStatistics(anyString(), anyInt(), anyInt());
        doCallRealMethod().when(mockedGame).setPlayer1(anyString());
        doCallRealMethod().when(mockedGame).setPlayer2(anyString());
        doCallRealMethod().when(mockedGame).setFileProcess(mockedFileProcess);

        mockedGame.setFileProcess(mockedFileProcess);
        mockedGame.setPlayer1("asdf");
        mockedGame.setPlayer2("asdff");
        mockedGame.play();

        verify(mockedFileProcess).updatePlayerStatistics("asdf", 1, 0);
        verify(mockedFileProcess).updatePlayerStatistics("asdff", 0, 1);
    }

    @AfterEach
    public void dropDb() throws IOException {
        FileProcess fileProcess = new FileProcess("playerdb.txt");
        fileProcess.dropDataBase();
    }
}
