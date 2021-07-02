package linkedlist;

// TODO 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class leetcode21 {
    public class ListNode {
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

    // TODO 迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sential = new ListNode(-1);
        ListNode point = sential;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        point.next = l1 == null ? l2 : l1;
        return sential.next;
    }

    // TODO 递归
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null)
//            return l2;
//        if (l2 == null)
//            return l1;
//        if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
}
