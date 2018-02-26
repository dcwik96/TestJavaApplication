public class Table {

    private int table[];

    public Table(int[] table) {
        super();
        this.table = table;
    }

    public int[] getTable() {
        return table;
    }


    public void setTable(int[] table) {
        this.table = table;
    }

    int largest(Table t) {
        int max = table[0];
        for (int counter = 1; counter < table.length; counter++) {
            if (table[counter] > max) {
                max = table[counter];
            }
        }

        return max;
    }

    int smallest(Table t) {
        int min = table[0];
        for (int counter = 1; counter < table.length; counter++) {
            if (table[counter] < min) {
                min = table[counter];
            }
        }

        return min;
    }

    boolean isSorted(Table t) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] > table[i + 1]) return false;
        }
        return true;
    }
}
