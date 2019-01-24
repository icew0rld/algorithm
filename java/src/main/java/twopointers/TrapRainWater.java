package twopointers;

/**
 * 题目：https://leetcode.com/problems/trapping-rain-water/
 * 难度：hard
 */
public class TrapRainWater {
    public int trap(int[] height) {
        // return bruteForce(height);
        // return dp(height);
        return twoPointers(height);
    }

    private int bruteForce(int[] height) {
        int sum = 0;
        int each = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            each = Math.min(leftMax, rightMax) - height[i];
            if (each > 0) {
                sum += each;
            }
        }

        return sum;
    }

    private int dp(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;
        int len = height.length;

        int[] rightMax = new int[len];
        int[] leftMax = new int[len];


        rightMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            rightMax[i] = Math.max(rightMax[i-1], height[i]);
        }

        leftMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            leftMax[i] = Math.max(leftMax[i+1], height[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    private int twoPointers(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
