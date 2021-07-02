package linkedlist;

// TODO  K-个翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
public class leetcode25 {

    //本题的目标非常清晰易懂，不涉及复杂的算法，但是实现过程中需要考虑的细节比较多，容易写出冗长的代码。
    // 主要考查面试者设计的能力。
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个假的节点。
        ListNode dummy = new ListNode(0);
        //假节点的next指向head。
        // dummy->1->2->3->4->5
        dummy.next = head;
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (end == null) {
                break;
            }
            //先记录下end.next,方便后面链接链表
            ListNode next = end.next;
            //然后断开链表
            end.next = null;
            //记录下要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    //链表翻转
    // 例子：   head： 1->2->3->4
    public ListNode reverse(ListNode head) {
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.next == null) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //下一个节点指针
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next;//nextNode 指向下一个节点,保存当前节点后面的链表。
            curNode.next = preNode;//将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            preNode = curNode;//preNode 指针向后移动。preNode指向当前节点。
            curNode = nextNode;//curNode指针向后移动。下一个节点变成当前节点
        }
        return preNode;
    }

    // TODO 官方解答
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode hair = new ListNode(0);
//        hair.next = head;
//        ListNode pre = hair;
//        while (head != null) {
//            ListNode tail = pre;
//            for (int i = 0; i < k; i++) {
//                tail = tail.next;
//                if (tail == null) {
//                    return hair.next;
//                }
//            }
//            ListNode nex = tail.next;
//            ListNode[] reverse = myReverse(head, tail);
//            head = reverse[0];
//            tail = reverse[1];
//            // 接回原链表
//            pre.next = head;
//            tail.next = nex;
//            pre = tail;
//            head = tail.next;
//        }
//
//        return hair.next;
//    }
//
//    private ListNode[] myReverse(ListNode head, ListNode tail) {
//        ListNode prev = tail.next;
//        ListNode p = head;
//        while (prev != tail) {
//            ListNode nex = p.next;
//            p.next = prev;
//            prev = p;
//            p = nex;
//        }
//        return new ListNode[]{tail, head};
//    }
}
