package bitmanipulation;

/**
 * 题目：https://leetcode.com/problems/single-number-ii/
 * 难度：hard
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x2 & x1);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
