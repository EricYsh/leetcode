package array;

public class leetcode11 {
    public static int maxArea(int[] height) {
//        int max = 0;
//        // TODO 无重复遍历数组元素的 for 循环（超时）
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = (j - i) * Math.min(height[i], height[j]);
//                max = Math.max(max, area);
//            }
//        }
//        return max;
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(arr);
    }
}
