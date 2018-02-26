import java.util.Arrays;

public class Sorting {
    private int table[];

    public Sorting(int[] table) {
        super();
        this.table = table;
    }

    public int[] getTable() {
        return table;
    }

    public void setTable(int[] table) {
        this.table = table;
    }

    boolean isSorted(Sorting t) {
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] > table[i + 1])
                return false;
        }
        return true;
    }

    public Sorting sort(String option) {
        if (!option.equals("r") && !option.equals("m")) throw new IllegalArgumentException();

        int n = table.length;
        if (n == 0) throw new NullPointerException();

        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (option.equals("r")) {
                    if (table[j - 1] > table[j]) {
                        temp = table[j - 1];
                        table[j - 1] = table[j];
                        table[j] = temp;
                    }
                } else if (option.equals("m")) {
                    if (table[j - 1] < table[j]) {
                        temp = table[j - 1];
                        table[j - 1] = table[j];
                        table[j] = temp;
                    }
                }
            }
        }
        return new Sorting(table);
    }

    public String printArray() {
        return Arrays.toString(table);
    }

}
