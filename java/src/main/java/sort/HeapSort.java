package sort;

public class HeapSort {
    public static void sort(int[] a) {
        int n = a.length;
        for (int k = n/2; k>=1; k--) {
            sink(a, k, n);
        }
        while (n > 1) {
            Util.exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private void sink(int[] a, int i, int j) {

    }

    private void swim(int[] a, int k) {
        while (k > 1 && Util.less(a[k/2], a[k])) {
            Util.exch(a, k/2, k);
            k /= 2;
        }
    }
}
