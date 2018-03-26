package mavenTest2;

public class App<T extends Comparable<T>> {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        add();
    }

    public static int add() {
        return 2 + 2;
    }

    public int binarySearch(T[] nums, T check) {
        if (!checkIfSorted(nums)) return -1;

        int highest = nums.length - 1;
        int lower = 0;
        while (lower <= highest) {
            int guess = lower + ((highest - lower) / 2);
            if (nums[guess].compareTo(check) > 0) {
                highest = guess - 1;
            } else if (nums[guess].compareTo(check) < 0) {
                lower = guess + 1;
            } else {
                return guess;
            }
        }
        return -1;
    }

    public boolean checkIfSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
