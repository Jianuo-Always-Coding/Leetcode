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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> l = new ArrayList<>(); // 放入LinkList 能通过index 得到值
        while(head!= null){
            l.add(head.val);
            head = head.next;
        }
        return dfs(l, 0, l.size()-1);
    }

    private TreeNode dfs(List<Integer> l, int low, int high){
        if (low > high) return null;

        int mid = (low +high) /2;
        TreeNode node = new TreeNode(l.get(mid));
        node.left = dfs(l, low, mid-1);
        node.right = dfs(l, mid+1, high);

        return node;
    }
}