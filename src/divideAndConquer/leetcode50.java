package divideAndConquer;

//TODO 50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
public class leetcode50 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    // 递归
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x; // 奇数要多乘一次
    }
}
