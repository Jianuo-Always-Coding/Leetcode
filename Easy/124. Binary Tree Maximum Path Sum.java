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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, int[] result) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftValue = Math.max(helper(root.left, result), 0);
        int rightValue = Math.max(helper(root.right, result), 0);
        result[0] = Math.max(result[0], root.val + leftValue + rightValue);
        return root.val + Math.max(leftValue, rightValue);
    }
}