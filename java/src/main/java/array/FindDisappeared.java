package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        return swapMethod(nums);
    }

    /**
     * swap法
     * @param nums
     * @return
     */
    private List<Integer> swapMethod(int [] nums) {
        List<Integer> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
                i++;
            } else {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * mark法
     * @param nums
     * @return
     */
    public List<Integer> mark(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }


}
