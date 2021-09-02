package search;

import java.util.ArrayList;
import java.util.List;

// 22. 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
public class leetcode22 {
    //回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当
    //它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚
    //至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        //回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
        //• 找到一个可能存在的正确的答案
        //• 在尝试了所有可能的分步方法后宣告该问题没有答案
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;  //在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
