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
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        helper(maxSum, root);
        return maxSum[0];
    }

    // return the max value contains this node
    private int helper(int[] maxSum, TreeNode root) {
        // corner case
        if (root.left == null && root.right == null) {
            maxSum[0] = Math.max(maxSum[0], root.val);
            return root.val;
        }
        int leftSum = 0;
        int rightSum = 0;
        if (root.left != null) {
            leftSum = Math.max(leftSum, helper(maxSum, root.left));
        }
        if (root.right != null) {
            rightSum = Math.max(rightSum, helper(maxSum, root.right));
        }
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}