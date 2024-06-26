/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println("slow is: " + slow.val);
            // System.out.println("fast is: " + fast.val);
            if (slow == fast) {
                return true;
            }
        }
        //solution by devvarunbhardwaj -VARUN 
        return false;
    }
}