package permutation;

/**
 * 问题：https://leetcode.com/problems/permutations/
 */

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        permuteHelper(nums, 0, ans);
        return ans;
    }

    private void permuteHelper(int[] nums, int i, List<List<Integer>> l) {
        if (i == nums.length) {
            List<Integer> perm = new LinkedList<>();
            for (int x : nums) {
                perm.add(x);
            }
            l.add(perm);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(nums, i + 1, l);
            swap(nums, i, j);// backtracking
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
