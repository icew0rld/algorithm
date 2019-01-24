package bitmanipulation;

/**
 * 问题：https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        diff &= -diff;
        int[] res = {0, 0};
        for (int i : nums) {
            if ((diff & i) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
