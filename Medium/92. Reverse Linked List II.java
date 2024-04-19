
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // corner case
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int index = 0;
        ListNode cur = dummy;
        while (index < left - 1) {
            cur = cur.next;
            index++;
        }

        ListNode node1 = cur;
        cur = cur.next;
        ListNode node2 = cur;
        node1.next = null;
        index++;

        while (index < right) {
            cur = cur.next;
            index++;
        }
        ListNode node3 = cur;
        ListNode node4 = cur.next;
        cur.next = null;
        ListNode newNode = reverse(node2);
        node1.next = node3;
        node2.next = node4;
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}