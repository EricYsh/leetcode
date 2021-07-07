package stackAndQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// TODO  有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
public class leetcode20 {
    // 涉及到括号、表达式等这一类的问题， 我们发现有个共同的特点是”最近相关性“ ，这类问题，使用栈来解决。
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1)
            return false;
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)){
                if (stack.isEmpty() || stack.peek() != pairs.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
