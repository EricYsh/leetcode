package dynamicProgramming;

// 1143. 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
public class leetcode1143 {
    // 最长公共子序列问题是典型的二维动态规划问题
    public int longestCommonSubsequence(String text1, String text2) {
        //假设字符串 text1 和 text2 的长度分别为 m 和 n，
        //  创建 m+1 行 n+1 列的二维数组 dp，其中dp[i][j] 表示 text1[0:i] 和 text2 [0:j] 的最长公共子序列的长度。
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
