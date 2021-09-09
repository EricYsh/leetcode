package bitOperations;

// 231. 2 的幂 https://leetcode-cn.com/problems/power-of-two/
public class leetcode231 {
    // solution 1
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    // solution 2
//    public boolean isPowerOfTwo(int n) {
//        return n > 0 && (n & -n) == n;
//    }
}
