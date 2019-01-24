package javaconvention;

import util.io.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortWithComparator {
    public static void main(String[] args) {
        int[] a = {1, 3, 2};
        Arrays.sort(a);
        Print.printArray(a);

        Integer[] b = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : (o1 == o2 ? 0 : -1);
            }
        });
        System.out.println(Arrays.toString(b));

        //same with lambda
        Integer[] c = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        Arrays.sort(c, (o1, o2) -> o1 < o2 ? 1 : (o1 == o2 ? 0 : -1));
        System.out.println(Arrays.toString(c));

    }
}
