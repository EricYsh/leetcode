package binarySearch;

// 74. 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
public class leetcode74 {
    // one time binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1; // consider as one line
        while (low <= high) {
            int mid = (high - low) / 2 + low; // get mid
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
