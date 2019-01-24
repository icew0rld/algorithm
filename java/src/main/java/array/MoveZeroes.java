package array;

/**
 * 问题：https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int i = 0, j = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    j++;
                }
            }
        }
    }
}
