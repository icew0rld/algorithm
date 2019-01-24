package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题：https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    /**
     * boyer-moore voting
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for (int i : nums) {
            if (count == 0) {
                ans = i;
            }
            count += (i == ans) ? 1 : -1;
        }
        return ans;
    }

    public int hashTableMethod(int[] nums) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int ans = 0;
        for (int i : nums) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
            if (m.get(i) > nums.length / 2) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
