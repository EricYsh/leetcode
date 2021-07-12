package stackAndQueue;

// TODO 641.设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
public class MyCircularDeque {
    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    private class Node {
        Node prev;
        int item;
        Node next;

        Node(Node p, int i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;
    private int k;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        sentinel = new Node(null, 0, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        this.size = k;
        this.k = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size <= 0)
            return false;
        Node n = new Node(sentinel, value, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;
        size--;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size <= 0)
            return false;
        Node node = new Node(sentinel.prev, value, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size--;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == k)
            return false;
        int del = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size++;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == k)
            return false;
        int last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size++;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return sentinel.next.item;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return sentinel.prev.item;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == k;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == 0;
    }
}
