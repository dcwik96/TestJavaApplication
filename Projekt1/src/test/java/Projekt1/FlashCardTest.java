package Projekt1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FlashCardTest {

    private final int columns = 7;
    private final int rows = 6;
    private FlashCard flashCard;
    private int[][] arr;

    @BeforeEach
    public void setUp() {
        flashCard = new FlashCard();
        arr = new int[columns][rows];
    }

    @Test
    public void checkIfColumnsAreProperlyCreated() {
        assertEquals(columns, flashCard.getArr().length);
    }

    @Test
    public void checkIfRowsAreProperlyCreated() {
        assertEquals(rows, flashCard.getArr()[1].length);
    }

    @Test
    public void checkIfSetPlayerOnFlashCardReturnsTrueWhenSuccess() {
        int pickedColumn = 0;
        int playerNo = 1;
        assertTrue(flashCard.setPlayerOnFlashCard(pickedColumn, playerNo));
    }

    @Test
    public void checkIfSetPlayerOnFlashCardReturnsFalseWhenFailed() {
        int pickedColumn = 7;
        int playerNo = 1;
        assertFalse(flashCard.setPlayerOnFlashCard(pickedColumn, playerNo));
    }

    @Test
    public void checkIfSetPlayerOnFlashCardReturnsFalseWhenColumnsValueIsNegative() {
        int pickedColumn = -1;
        int playerNo = 1;
        assertFalse(flashCard.setPlayerOnFlashCard(pickedColumn, playerNo));
    }

    @Test
    public void checkIfSetPlayerOnFlashCardModifyArrayProperly() {
        int pickedColumn = 0;
        int playerNo = 1;
        flashCard.setPlayerOnFlashCard(pickedColumn, playerNo);
        assertEquals(playerNo, flashCard.getArr()[0][5]);
    }

    @Test
    public void checkIfSearchForLowestPositionReturnsProperly() {
        int pickedColumn = 0;
        arr[pickedColumn][5] = 1;
        arr[pickedColumn][4] = 1;
        flashCard.setArr(arr);

        assertEquals(3, flashCard.searchForLowestPosition(pickedColumn));
    }

    @Test
    public void checkIfSearchForLowestPositionReWhenNoPlaceInColumn() {
        final int pickedColumn = 0;
        arr[pickedColumn][0] = 1;
        arr[pickedColumn][1] = 1;
        arr[pickedColumn][2] = 1;
        arr[pickedColumn][3] = 1;
        arr[pickedColumn][4] = 1;
        arr[pickedColumn][5] = 1;
        flashCard.setArr(arr);

        assertThrows(IllegalArgumentException.class, () -> flashCard.searchForLowestPosition(pickedColumn));
    }

    @Test
    public void checkIfCheckIfSbWinReturnFalseWhenNoWinner() {
        assertFalse(flashCard.checkIfSbWin());
    }

    //tutaj zrobic z pliku testy dla kazdej kolumny  i kazdego gracza!!!
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfCheckIfSbWinAndReturnHisNumberReturnNumberWhenHorizontal(int playerNo) {
        arr[0][5] = playerNo;
        arr[0][4] = playerNo;
        arr[0][3] = playerNo;
        arr[0][2] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.checkIfSbWin());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfCheckIfSbWinAndReturnHisNumberReturnNumberWhenVertical(int playerNo) {
        arr[0][5] = playerNo;
        arr[1][5] = playerNo;
        arr[2][5] = playerNo;
        arr[3][5] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.checkIfSbWin());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfCheckIfSbWinAndReturnHisNumberReturnNumberWhenSkew(int playerNo) {
        arr[0][5] = playerNo;
        arr[1][4] = playerNo;
        arr[2][3] = playerNo;
        arr[3][2] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.checkIfSbWin());
    }

    //testy z pliku wszsytkie kombinacje
    @ParameterizedTest
    @CsvFileSource(resources = "/columnCorrect.csv", numLinesToSkip = 1)
    public void checkIfIsFourInColumnCorrect(int x, int y1, int y2, int y3, int y4, int playerNo) {
        arr[x][y4] = playerNo;
        arr[x][y3] = playerNo;
        arr[x][y2] = playerNo;
        arr[x][y1] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.isFourInColumn());
    }

    //testy z pliku wszsytkie kombinacje ( za wysoko)
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfIsFourInColumnWrong(int playerNo) {
        arr[0][5] = playerNo;
        arr[0][4] = playerNo;
        arr[0][3] = playerNo;
        flashCard.setArr(arr);

        assertFalse(flashCard.isFourInColumn());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/rowCorrect.csv", numLinesToSkip = 1)
    public void checkIfIsFourInRowCorrect(int x1, int x2, int x3, int x4, int y, int playerNo) {
        arr[x1][y] = playerNo;
        arr[x2][y] = playerNo;
        arr[x3][y] = playerNo;
        arr[x4][y] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.isFourInRow());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfIsFourInRowWrong(int playerNo) {
        arr[0][5] = playerNo;
        arr[1][5] = playerNo;
        arr[2][5] = playerNo;
        flashCard.setArr(arr);

        assertFalse(flashCard.isFourInRow());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfIsFourInCrossCorrect(int playerNo) {
        arr[0][5] = playerNo;
        arr[1][4] = playerNo;
        arr[2][3] = playerNo;
        arr[3][2] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.isFourInCross());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void checkIfIsFourInCrossCorrectElse(int playerNo) {
        arr[6][5] = playerNo;
        arr[5][4] = playerNo;
        arr[4][3] = playerNo;
        arr[3][2] = playerNo;
        flashCard.setArr(arr);

        assertTrue(flashCard.isFourInCross());
    }

    @Test
    public void checkIfIsPlaceReturnTrueProperly() {
        assertTrue(flashCard.isPlace());
    }

    @Test
    public void checkIfIsPlaceReturnFalseWhenFullArr() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[j][i] = 1;
            }
        }

        flashCard.setArr(arr);

        assertThat(flashCard.isPlace()).isFalse();
    }


}
