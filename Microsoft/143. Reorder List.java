/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return ;
        }

        ListNode midNode = findMid(head);
        ListNode twoTemp = midNode.next;
        midNode.next = null;
        ListNode two = reverse(twoTemp);
        ListNode one = head;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur = cur.next;
            cur.next = two;
            two = two.next;
            cur = cur.next;
        }

        if (one != null) {
            cur.next = one;
        }
        return ;
    }

    private ListNode reverse(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}