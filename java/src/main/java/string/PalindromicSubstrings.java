package string;

/**
 * 问题：https://leetcode.com/problems/palindromic-substrings/
 *
 */

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        // return bf(s);
        return expand(s);
    }

    public int bf(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int lo = i;
                int hi = j;
                boolean yes = true;
                while (lo <= hi) {
                    if (s.charAt(lo) != s.charAt(hi)) {
                        yes = false;
                        break;
                    }
                    lo++;
                    hi--;
                }
                if (yes) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int expand(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += expand(s, i, i);
            ans += expand(s, i, i + 1);
        }
        return ans;
    }

    private int expand(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}
