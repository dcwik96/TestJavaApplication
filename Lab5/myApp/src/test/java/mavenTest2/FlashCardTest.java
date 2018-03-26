package mavenTest2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlashCardTest {

    private FlashCard flashCard;
    private int sizeOfFlashCard;

    @BeforeEach
    public void setUp() {
        sizeOfFlashCard = 3;
        flashCard = new FlashCard(sizeOfFlashCard, sizeOfFlashCard);
    }

    @Test
    public void checkChequerPlacedCorrectly() {
        int x = 2;
        int y = 1;
        assertTrue(flashCard.setPlayerOnFlashCard(x, y));
    }

    @Test
    public void checkChequerPlacedOutOfXFlashCard() {
        int x = 10;
        int y = 2;
        assertFalse(flashCard.setPlayerOnFlashCard(x, y));
    }

    @Test
    public void checkChequerPlacedOutOfYFlashCard() {
        int x = 2;
        int y = 10;
        assertFalse(flashCard.setPlayerOnFlashCard(x, y));
    }

    @Test
    public void checkIfReturnFalseWhenPlaceIsOccupied() {
        int x = 2;
        int y = 2;
        flashCard.setPlayerOnFlashCard(x, y);
        assertFalse(flashCard.setPlayerOnFlashCard(x, y));
    }
//UDRL
    @Test
    public void checkIfMovedProperly() {
        int x = 0;
        int y = 0;
        flashCard.setPlayerOnFlashCard(x, y);

        String direction = "r";
        int newPlaceX = 1;
        int newPlaceY = 0;

        assertEquals(1, flashCard.moveChequer(direction)[newPlaceX][newPlaceY]);
    }

    @Test
    public void checkIfMovedOutOfX() {
        int x = sizeOfFlashCard-1;
        int y = sizeOfFlashCard-1;
        flashCard.setPlayerOnFlashCard(x, y);

        final String direction = "r";

        assertThrows(IllegalArgumentException.class, () -> flashCard.moveChequer(direction));
    }

    @Test
    public void checkIfMovedOutOfY() {
        int x = sizeOfFlashCard-1;
        int y = sizeOfFlashCard-1;
        flashCard.setPlayerOnFlashCard(x, y);

        final String direction = "d";

        assertThrows(IllegalArgumentException.class, () -> flashCard.moveChequer(direction));
    }

}
