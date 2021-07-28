package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// TODO 264. 丑数 II https://leetcode-cn.com/problems/ugly-number-ii/
public class leetcode264 {
    // use heap
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>(); // 集合保证无重复
        PriorityQueue<Long> heap = new PriorityQueue<>();  // 维护一个 mini heap
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr; // 也就是栈顶元素
            for (int factor : factors) {  // 乘以每个factor，保证是丑数
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
