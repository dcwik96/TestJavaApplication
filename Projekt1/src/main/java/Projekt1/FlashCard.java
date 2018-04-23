package Projekt1;

public class FlashCard {

    private int columns = 7;
    private int rows = 6;
    private int[][] arr;

    public FlashCard() {
        this.arr = new int[columns][rows];
    }

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }


    public boolean setPlayerOnFlashCard(int x, int player) {
        if (x <= columns - 1 && x >= 0) {
            arr[x][searchForLowestPosition(x)] = player;
            return true;
        }
        return false;
    }

    public int searchForLowestPosition(int x) {
        for (int i = rows - 1; i >= 0; i--)
            if (arr[x][i] == 0) return i;
        throw new IllegalArgumentException();
    }

    public boolean checkIfSbWin() {
        return isFourInColumn() || isFourInRow() || isFourInCross();
    }

    public boolean isFourInColumn() {
        for (int i = rows - 1; i >= 3; i--) {
            for (int j = columns - 1; j >= 0; j--) {

                if (arr[j][i] == 1) {
                    if (arr[j][i - 1] == 1 && arr[j][i - 2] == 1 && arr[j][i - 3] == 1) {
                        return true;
                    }
                } else if (arr[j][i] == 2) {
                    if (arr[j][i - 1] == 2 && arr[j][i - 2] == 2 && arr[j][i - 3] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isFourInRow() {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 3; j--) {

                if (arr[j][i] == 1) {
                    if (arr[j - 1][i] == 1 && arr[j - 2][i] == 1 && arr[j - 3][i] == 1) {
                        return true;
                    }
                } else if (arr[j][i] == 2) {
                    if (arr[j - 1][i] == 2 && arr[j - 2][i] == 2 && arr[j - 3][i] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isFourInCross() {
        for (int i = rows - 1; i >= 3; i--) {
            for (int j = columns - 1; i >= 3; i--) {
                if (arr[j][i] == 1) {
                    if (arr[j - 1][i - 1] == 1 && arr[j - 2][i - 2] == 1 && arr[j - 3][i - 3] == 1) {
                        return true;
                    }
                } else if (arr[j][i] == 2) {
                    if (arr[j - 1][i - 1] == 2 && arr[j - 2][i - 2] == 2 && arr[j - 3][i - 3] == 2) {
                        return true;
                    }
                }
            }
        }
        for (int i = rows - 1; i >= 3; i--) {
            for (int j = 3; j >= 0; j--) {
                if (arr[j][i] == 1) {
                    if (arr[j + 1][i - 1] == 1 && arr[j + 2][i - 2] == 1 && arr[j + 3][i - 3] == 1) {
                        return true;
                    }
                } else if (arr[j][i] == 2) {
                    if (arr[j + 1][i - 1] == 2 && arr[j + 2][i - 2] == 2 && arr[j + 3][i - 3] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void printArr() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
    }

    public boolean isPlace() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[j][i] == 0) return true;
            }
        }
        return false;
    }
}
