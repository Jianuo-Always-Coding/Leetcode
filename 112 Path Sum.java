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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // corner case
        if (root == null) {
            return false;
        }
        boolean[] seen = new boolean[1];
        helper(root, seen, targetSum, 0);
        return seen[0];
    }

    private void helper(TreeNode root, boolean[] seen, int targetSum, int sum) {
        if (seen[0]) {
            return ;
        }
        // base case
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                seen[0] = true;
            }
            return ;
        }
        if (root.left != null) {
            helper(root.left, seen, targetSum, sum + root.val);
        }
        if (root.right != null) {
            helper(root.right, seen, targetSum, sum + root.val);
        }
    }
}