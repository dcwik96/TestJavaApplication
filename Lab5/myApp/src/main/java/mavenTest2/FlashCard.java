package mavenTest2;

import java.util.Arrays;

public class FlashCard {

    private int[][] arr;

    public FlashCard(int x, int y) {
        this.arr = new int[x][y];
        for (int[] row : arr)
            Arrays.fill(row, 0);
    }

    public boolean setPlayerOnFlashCard(int x, int y) {
        if (x <= arr.length && y <= arr[1].length && arr[x][y] == 0) {
            arr[x][y] = 1;
            return true;
        }
        return false;
    }

    //udrl
    public int[][] moveChequer(String direction) {
        int x = 0, y = 0;


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if (arr[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        if (direction.equalsIgnoreCase("u")) {
            if (y == 0) throw new IllegalArgumentException();
            else {
                arr[x][y] = 0;
                arr[x][y - 1] = 1;
            }
        } else if (direction.equalsIgnoreCase("d")) {
            if (arr[1].length - 1 == y) throw new IllegalArgumentException();
            else {
                arr[x][y] = 0;
                arr[x][y + 1] = 1;
            }

        } else if (direction.equalsIgnoreCase("r")) {
            if (arr.length - 1 == x) throw new IllegalArgumentException();
            else {
                arr[x][y] = 0;
                arr[x + 1][y] = 1;
            }
        } else if (direction.equalsIgnoreCase("l")) {
            if (x == 0) throw new IllegalArgumentException();
            else {
                arr[x][y] = 0;
                arr[x - 1][y] = 1;
            }
        } else throw new IllegalArgumentException();


        return arr;
    }
}
