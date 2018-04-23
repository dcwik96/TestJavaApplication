package Projekt1;

import java.io.IOException;
import java.util.Scanner;

public class Game {


    private FlashCard flashCard;
    private Scanner scanner = new Scanner(System.in);
    private String player1;
    private String player2;
    private FileProcess fileProcess = new FileProcess("playerdb.txt");

    public Game() {
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void setFileProcess(FileProcess fileProcess) {
        this.fileProcess = fileProcess;
    }

    public void askForNames() {
        System.out.println("Podaj nick gracza1:");
        player1 = read();

        System.out.println("Podaj nick gracza2:");
        player2 = read();
    }

    public void run() throws IOException {
        String decision;
        do {
            printRules();
            decision = read();
            if (decision.equals("1")) {
                play();
            } else if (decision.equals("2")) {
                fileProcess.printStatistics();
            }
        } while (!decision.equals("0"));
    }

    public void play() throws IOException {
        flashCard = new FlashCard();
        while (true) {
            flashCard.printArr();
            System.out.println("-=Gracz 1=-\nPodaj kolumne:");

            flashCard.setPlayerOnFlashCard(Integer.parseInt(read()), 1);
            if (flashCard.checkIfSbWin()) {

                System.out.println("WYGRYWA 1");
                if (fileProcess.findPlayerInDB(player1) == -1) {
                    saveNewWinnerPlayer(1);
                } else {
                    fileProcess.updatePlayerStatistics(player1, 1, 0);
                }
                if (fileProcess.findPlayerInDB(player2) == -1) {
                    saveNewLooserPlayer(2);
                } else {
                    fileProcess.updatePlayerStatistics(player2, 0, 1);

                }
                break;
            }
            flashCard.printArr();
            System.out.println("-=Gracz 2=-\nPodaj kolumne:");
            flashCard.setPlayerOnFlashCard(Integer.parseInt(read()), 2);
            if (flashCard.checkIfSbWin()) {

                System.out.println("WYGRYWA 2");
                if (fileProcess.findPlayerInDB(player2) == -1) {
                    saveNewWinnerPlayer(2);
                } else {
                    fileProcess.updatePlayerStatistics(player2, 1, 0);
                }
                if (fileProcess.findPlayerInDB(player1) == -1) {
                    saveNewLooserPlayer(1);
                } else {
                    fileProcess.updatePlayerStatistics(player1, 0, 1);
                }
                break;
            }

            if (!flashCard.isPlace()) {

                System.out.println("Remis!");

                if (fileProcess.findPlayerInDB(player1) == -1) {
                    saveNewWinnerPlayer(1);
                } else {
                    fileProcess.updatePlayerStatistics(player1, 1, 0);
                }
                if (fileProcess.findPlayerInDB(player2) == -1) {
                    saveNewWinnerPlayer(2);
                } else {
                    fileProcess.updatePlayerStatistics(player2, 1, 0);

                }
                break;
            }
        }
    }

    public void saveNewLooserPlayer(int no) throws IOException {
        if (no == 1) {
            Player p = new Player(player1, 0, 1);
            fileProcess.saveToFileWholePlayer(p);
        } else if (no == 2) {
            Player p = new Player(player2, 0, 1);
            fileProcess.saveToFileWholePlayer(p);
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void saveNewWinnerPlayer(int no) throws IOException {
        if (no == 1) {
            Player p = new Player(player1, 1, 0);
            fileProcess.saveToFileWholePlayer(p);
        } else if (no == 2) {
            Player p = new Player(player2, 1, 0);
            fileProcess.saveToFileWholePlayer(p);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String read() {
        String read;
        scanner = new Scanner(System.in);
        read = scanner.nextLine();
        return read;
    }


    public void printRules() {
        System.out.println("Celem gry jest umieszczenie czterech krążków w swoim kolorze w pionie, w poziomie lub po przekątnej\nWygrywa osoba, która zrobi to pierwsza.");
        System.out.println("0 - wyjdz z gry");
        System.out.println("1 - zagraj");
        System.out.println("2 - wyswietl statystyki");
    }
}
