package unclassified;

import java.util.LinkedList;
import java.util.List;

public class LargestTime {
    public static void main(String[] args) {
        System.out.println(new LargestTime().largestTimeFromDigits(new int[]{0,0,1,0}));
    }

    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> permutations = permute(A);
        List<Integer> max = null;
        for (List<Integer> l : permutations) {
            if (isValid(l)) {
                if (max == null) {
                    max = l;
                } else {
                    if (isLarger(l, max)) {
                        max = l;
                    }
                }
            }
        }
        if (max == null) {
            return "";
        } else {
            return max.get(0) + "" + max.get(1) + ":" + max.get(2) + "" + max.get(3);
        }

    }

    private boolean isLarger(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) == l2.get(i)) {
                continue;
            } else if (l1.get(i) > l2.get(i)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean isValid(List<Integer> l) {
        if (l.get(0) > 2) {
            return false;
        }

        if (l.get(0) == 2) {
            if (l.get(1) >3) {
                return false;
            }
        }
        if (l.get(2) > 5) {
            return false;
        }
        return true;
    }

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
