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
        // corner case
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        // result 赋值应该为MIN_VALUE
        result[0] = Integer.MIN_VALUE;
        find(root, result);
        return result[0];
    }

    private int find(TreeNode root, int[] result) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftVal = Math.max(0, find(root.left, result));
        int rightVal = Math.max(0, find(root.right, result));
        // 更新result
        result[0] = Math.max(result[0], leftVal + root.val + rightVal);
        if (Math.max(leftVal, rightVal) > 0) {
            return Math.max(leftVal, rightVal) + root.val;
        } 
        return root.val;
        
    }
}
