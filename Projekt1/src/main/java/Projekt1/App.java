package Projekt1;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.askForNames();
        game.run();
    }
}
