package greedy;

// TODO 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
public class leetcode322 {
    // 记忆化存储的递归
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {  // 不知道最后一枚硬币的面值是多少，所以需要枚举每个硬币面额值
            int res = coinChange(coins, rem - coin, count); // F(S) = F(S−C) + 1 状态方程
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min; // 如 不存在 返回 -1
        return count[rem - 1];
    }
}
