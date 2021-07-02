package linkedlist;

import java.util.HashSet;
import java.util.Set;

// TODO 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
public class leetcode141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // TODO solution1 hash table
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> have = new HashSet<>();
//        while (head != null) {
//            if (!have.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

    // TODO solution2 Floyd method
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
