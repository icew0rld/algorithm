package dp;

/**
 * topic：dp，dc
 * 题目：https://leetcode.com/problems/burst-balloons/
 * 思路：
 *  dc:用最后一个气球（而不是第一个），把问题切分为不重叠的子问题
 *  dp:虽然每次切分的2部分不重叠，但不同的切分有重叠，因此需要记忆化。
 *
 *  所以本题难道为hard，结合了dc和dp。代码是用top down记忆法（+递归），也可以用bottom up（+迭代），参考以上链接中的讨论部分。
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int[] processedNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                processedNums[n++] = x;
            }
        }
        processedNums[0] = 1;
        processedNums[n++] = 1;

        int[][] dp = new int[n][n];
        return process(processedNums, 0, n - 1, dp);
    }

    private int process(int[] nums, int lo, int hi, int[][] dp) {
        if (lo + 1 == hi) {
            return 0;
        }
        if (dp[lo][hi] != 0) {
            return dp[lo][hi];
        }

        for (int i = lo + 1; i < hi; i++) {
            dp[lo][hi] = Math.max(dp[lo][hi], nums[i] * nums[lo] * nums[hi] +
                    process(nums, lo, i, dp) + process(nums, i, hi, dp));
        }
        return dp[lo][hi];

    }
}
