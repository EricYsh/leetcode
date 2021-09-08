package bitOperations;

// 191. 位1的个数 https://leetcode-cn.com/problems/number-of-1-bits/
public class leetcode191 {

    //我们不断让当前的 n 与 n - 1 做与运算，直到 n 变为 0 即可。
    // 因为每次运算会使得 n 的最低位的 1 被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
