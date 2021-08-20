package binarySearch;

// TODO 69. x 的平方根 https://leetcode-cn.com/problems/sqrtx/
public class leetcode69 {
    //binary search to tackle this problem
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
