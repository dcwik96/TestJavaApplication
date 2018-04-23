package Projekt1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player player;
    private String name = "Gracz";
    private int wins = 0;
    private int loses = 0;


    @BeforeEach
    public void setUp() {
        player = new Player(name, wins, loses);
    }

    @Test
    public void checkIfPlayerNameSetProperly() {
        assertEquals(name, player.getName());
    }

    @Test
    public void checkIfPlayerWinsSetProperly() {
        assertEquals(wins, player.getWins());
    }

    @Test
    public void checkIfPlayerLosesSetProperly() {
        assertEquals(loses, player.getLoses());
    }

    @Test
    public void checkIfOneArgumentConstructorWorksProperly() {
        player = new Player(name);
        assertEquals(name, player.getName());
        assertThat(player.getName()).startsWith("Gra").endsWith("cz").isEqualToIgnoringCase("gracz");
    }
}
