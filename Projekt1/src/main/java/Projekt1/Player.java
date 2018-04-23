package Projekt1;

public class Player {

    private String name;
    private int wins;
    private int loses;

    public Player(String name, int wins, int loses) {
        this.name = name;
        this.wins = wins;
        this.loses = loses;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }
}
