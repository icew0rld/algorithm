package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 问题：https://leetcode.com/problems/queue-reconstruction-by-height/
 * topic: sort
 * 难度：Medium
 */

public class QueueReconstruction {
    public static void main(String[] args) {
        QueueReconstruction qr = new QueueReconstruction();
        int[][] testCase = new int[][] {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] res = qr.reconstructQueue(testCase);
        for (int i = 0; i < res.length; i++){
            System.out.print(res[i][0] + " " + res[i][1] + "\n");
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        boolean[] marked = new boolean[people.length];
        int[][] res = new int[people.length][2];
        sort(people);
        for (int i = 0; i < people.length; i++) {
            int k = people[i][1];
            int h = people[i][0];

            int j = 0;
            int pos = -1;
            for (;j < marked.length; j++) {
                if (!marked[j] || res[j][0] == h) {
                    pos++;
                }
                if (pos == k) {
                    break;
                }
            }
            res[j] = people[i];
            marked[j] = true;
        }
        return res;
    }

    private void sort(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int first = Integer.compare(o1[0], o2[0]);
                if (first != 0) {
                    return first;
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });
    }
}
