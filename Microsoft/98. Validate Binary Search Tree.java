/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // corner case
        if (root == null) {
            return true;
        }
        // 左面最大不能等于和右面最大不能等于
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        // base case
        if (root == null) {
            return true;
        }

        //满足去下一层直到最后
        if (root.val > min && root.val < max) {
            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
        }
        // 不满足就是false
        return false;
    }
}