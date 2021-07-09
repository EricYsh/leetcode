package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

// TODO 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
public class leetcode84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return heights[0];

        int area = 0;
        int[] newHeight = new int[len + 2];  // 前后增加高度为0的哨兵点，简化代码
        for (int i = 0; i < len; i++) {
            newHeight[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeight;

        Deque<Integer> stack = new ArrayDeque<>(); // 空间换时间的思想（相比暴力）
        stack.addLast(0);
        for (int i = 0; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.addLast(i);
        }
        return area;
    }
}
