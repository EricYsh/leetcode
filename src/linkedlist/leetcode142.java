package linkedlist;

// TODO 环形链表2 https://leetcode-cn.com/problems/linked-list-cycle-ii/
public class leetcode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // TODO 快慢指针，数学方法
    // slow * 2 = fast
    // slow = a + b
    // fast = a + b + c + b
    // 因为快每次走两部，假如慢走了环的一半，快指针必定走完一圈赶上慢指针，所以一环内必相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode point = head;
                while (point != slow) {
                    point = point.next;
                    slow = slow.next;
                }
                return point;
            }
        }
        return null;
    }

//    // TODO 暴力办法，遍历一遍列表
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> had = new HashSet<>();
//        while (head != null) {
//            if (!had.add(head)){
//                return head;
//            }
//            head = head.next;
//        }
//        return null;
//    }
}
