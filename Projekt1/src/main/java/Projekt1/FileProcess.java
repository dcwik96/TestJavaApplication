package Projekt1;

import java.io.*;
import java.util.ArrayList;

public class FileProcess {

    private String filePath;

    public FileProcess(String filePath) {
        this.filePath = filePath;
    }


    public ArrayList<String[]> readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String[]> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] splits = line.split(",");
                lines.add(splits);
            }
            return lines;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }

    }

    public void printStatistics() throws IOException {
        ArrayList<String[]> dataBase = readFromFile();
        System.out.println("NAME\tWINS\tLOSES");
        for (int i = 0; i < dataBase.size(); i++) {
            System.out.println(dataBase.get(i)[0] + "\t" + dataBase.get(i)[1] + "\t\t" + dataBase.get(i)[2]);
        }
    }

    public void saveToFileWholePlayer(Player player) throws IOException {
        if (findPlayerInDB(player.getName()) == -1) {
            String data = player.getName() + "," + player.getWins() + "," + player.getLoses();
            try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
                out.println(data);
            }
        }
    }

    public int findPlayerInDB(String name) throws IOException {
        ArrayList<String[]> actualDB = readFromFile();
        for (int i = 0; i < actualDB.size(); i++) {
            if (actualDB.get(i)[0].equals(name)) return i;
        }
        return -1;
    }

    public void dropDataBase() throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, false))) {
            out.flush();
            out.close();
        }
    }

    public void updatePlayerStatistics(String name, int plusWins, int plusLoses) throws IOException {
        int noLine = findPlayerInDB(name);
        ArrayList<String[]> actualDB = readFromFile();
        dropDataBase();
        String[] toChange = actualDB.get(noLine);
        int actualWins = Integer.parseInt(toChange[1]);
        int actualLoses = Integer.parseInt(toChange[2]);
        actualWins += plusWins;
        actualLoses += plusLoses;
        toChange[1] = String.valueOf(actualWins);
        toChange[2] = String.valueOf(actualLoses);
        actualDB.set(noLine, toChange);
        for (String[] anActualDB : actualDB) {
            try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
                String data = anActualDB[0] + "," + anActualDB[1] + "," + anActualDB[2];
                out.println(data);
            }
        }
    }
}
