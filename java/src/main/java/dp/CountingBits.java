package dp;

/**
 * topic: dp, bitmanipulation manipulation
 * 问题：https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if (num == 0) {
            return res;
        }
        res[1] = 1;
        int base = 2;
        for (int i = 2; i <= num; i++) {
            if (i >= base * 2) {
                base *= 2;
            }
            //1)可改成减
            //2)可用res[i] = res[i & i - 1] + 1 (这样连base都不用了)
            //3)更短写法： f[i] = f[i >> 1] + (i & 1);
            res[i] = res[i % base] + 1;
        }
        return res;
    }
}


