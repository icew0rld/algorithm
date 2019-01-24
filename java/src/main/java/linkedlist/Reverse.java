package linkedlist;

/**
 * 题目：https://leetcode.com/problems/reverse-linked-list/
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Reverse {
    public ListNode reverseList(ListNode head) {
        // return iterate(head);
        return recurse(head);
    }
    public ListNode iterate(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public ListNode recurse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = recurse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
