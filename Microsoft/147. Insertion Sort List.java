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
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, it is already sorted
        }

        ListNode dummy = new ListNode(0); // Dummy node to serve as the head of the sorted list
        ListNode curr = head; // Pointer to traverse the original list

        while (curr != null) {
            ListNode nextNode = curr.next; // Save the next node of the current node

            // Find the correct position to insert the current node into the sorted list
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert the current node into the sorted list
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original list
            curr = nextNode;
        }

        return dummy.next; // Return the next node of the dummy node (head of the sorted list)
    }
}