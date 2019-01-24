package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题：https://leetcode.com/problems/single-number/submissions/
 * 难度：easy
 * 要求：空间复杂度O(1),时间复杂度O(n)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    /**
     * hash table解法
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                s.remove(nums[i]);
            } else {
                s.add(nums[i]);
            }
        }
        int i = 0;
        for (int j : s) {
            i = j;
        }
        return i;
    }
}
