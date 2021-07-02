package linkedlist;

public class leetcode206 {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode test = null;
        test = new ListNode(1, test);
        test = new ListNode(2, test);
        reverseList(test);
    }

    // TODO 无脑办法
//    public ListNode reverseList(ListNode head) {
//        ListNode ans = null;
//        for (ListNode x = head; x != null; x = x.next) {
//            ans = new ListNode(x.val, ans);
//        }
//        return ans;
//    }
}
