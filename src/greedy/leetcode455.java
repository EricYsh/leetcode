package greedy;

import java.util.Arrays;

// TODO 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/description/
public class leetcode455 {
    // sort + greedy
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // children
        Arrays.sort(s); // cookie
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && g[i] > s[j]) { // 胃口大于能被满足，找下一个饼干
                j++;
            }
            if (j < s.length) { // 否则只需要未超过饼干数量，即可满足一个孩子
                count++;
            }
        }
        return count;
    }
}
