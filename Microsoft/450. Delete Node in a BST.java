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
    public TreeNode deleteNode(TreeNode root, int key) {
        // corner case
        if (root == null) {
            return root;
        }
        // 找node
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        // 找到了
        // 有一个为空
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // 删掉右子树中最小的
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        TreeNode prev = root;
        TreeNode cur = root.right;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        cur.left = root.left;
        cur.right = root.right;
        return cur;
    }
}