package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// TODO 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
public class MinStack {
    Deque<Integer> myStack;
    Deque<Integer> minStack;

    public MinStack() {
        myStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        myStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        myStack.pop();
        minStack.pop();
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
