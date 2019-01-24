package bitmanipulation;

/**
 * 问题：https://leetcode.com/problems/hamming-distance/
 * topic: bitmanipulation manipulation
 * 难度：easy
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while(z != 0) {
            if ((z & 1) != 0) {
                count++;
            }
            z >>>= 1;
        }
        return count;
    }
}
