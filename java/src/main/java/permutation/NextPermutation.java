package permutation;

/**
 * 题目：https://leetcode.com/problems/next-permutation/
 * 找比一个整数大的『同构』数中的最小的那个。
 * 同构指组成数字的位的数相同，但排列不同。比如1234与1243。即c++stl中类似next permutation函数的功能。
 */

/**
 * 思路：
 * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为*i，后一个记为*ii，
 * 并且满足*i < *ii。然后再从尾端寻找另一个元素*j，如果满足*i < *j，
 * 即将第i个元素与第j个元素对调，并将第ii个元素之后（包括ii）的所有元素颠倒排序，即求出下一个序列了。
 */

/**
 * 参考：
 * http://leonard1853.iteye.com/blog/1450085
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i > 0) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i-1]) {
                    swap(nums, i-1, j);
                    break;
                }
            }
        }
        reverse(nums, i, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}