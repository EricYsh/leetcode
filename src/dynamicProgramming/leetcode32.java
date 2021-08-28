package dynamicProgramming;

// 32. 最长有效括号 https://leetcode-cn.com/problems/longest-valid-parentheses/
public class leetcode32 {
    // dp
    //我们定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度。
    // 我们将 dp 数组全部初始化为 0 。
    // 显然有效的子串一定以 ‘)’ 结尾，因此我们可以知道以 ‘(’ 结尾的子串对应的 dp 值必定为 0 ，
    // 我们只需要求解 ‘)’ 在 dp 数组中对应位置的值。
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
