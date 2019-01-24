package array;

@FunctionalInterface
interface Operation {
    boolean isOk(int x);
}

public class OddBeforeEven {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        new OddBeforeEven().letOddBeforeEven(a, (x) -> (x & 1) != 0);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public void letOddBeforeEven(int[] a, Operation o) {
        if (a == null || a.length == 0) {
            return;
        }

        int even = 0;
        int odd = a.length - 1;
        while (even < odd) {
            while (o.isOk(a[even])) {
                even++;
            }
            while (!o.isOk(a[odd])) {
                odd--;
            }
            if (even < odd) {
                swap(a, even, odd);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
