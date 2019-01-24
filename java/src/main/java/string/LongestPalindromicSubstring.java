package string;

/**
 * 问题：https://leetcode.com/problems/longest-palindromic-substring/
 */

public class LongestPalindromicSubstring {
    private int max;
    private int left;
    private int right;

    public String longestPalindrome(String s) {
        // return expand(s);
        return dp(s);
    }

    public String expand(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        max = 1;
        left = 0;
        right = 0;
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > max) {
                max = right - left + 1;
                this.left = left;
                this.right = right;
            }
            left--;
            right++;
        }
    }

    public String dp(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }

                //以上可简化为 dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            }
        }

        //可以和以上循环合并
        for (int l = len; l >= 1; l--) {
            for (int i = 0; i + l - 1 < len; i++) {
                if (dp[i][i + l - 1]) {
                    return s.substring(i, i + l);
                }
            }
        }
        return null;

    }
}
