package sort;

public class Util {
    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(int x, int y) {
        return x < y;
    }
}
