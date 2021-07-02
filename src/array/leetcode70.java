package array;

public class leetcode70 {
    // 不会做题咋办？
    // 暴力解？基本情况是什么，找最近重复子问题
    // 计算机也就只能做 if else loop
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
