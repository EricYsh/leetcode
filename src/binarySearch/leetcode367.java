package binarySearch;

// 367. 有效的完全平方数 https://leetcode-cn.com/problems/valid-perfect-square/
public class leetcode367 {
    // binary search
    public boolean isPerfectSquare(int num) {
//        if (num < 2) return true;
//        int left = 2, right = num / 2, x, guess;
//        while (left <= right) {
//            x = left + (right - left) / 2;
//            guess = x * x;
//            if (guess == num) return true;
//            if (guess > num)
//                right = x - 1;
//            else
//                left = x + 1;
//        }
//        return false;
        if (num < 2) return true;
        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) return true;

            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
