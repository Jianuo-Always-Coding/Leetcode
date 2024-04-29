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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRightBoundary(root.right, result);
        return result;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> result) {
        if(root == null) return;
        if(root.left != null) {
            result.add(root.val);
            addLeftBoundary(root.left, result);
        } else if(root.right != null) {
            result.add(root.val);
            addLeftBoundary(root.right, result);
        }
    }

    private void addRightBoundary(TreeNode root, List<Integer> result) {
        if(root == null) return;
        if(root.right != null) {
            addRightBoundary(root.right, result);
            result.add(root.val);
        } else if(root.left != null) {
            addRightBoundary(root.left, result);
            result.add(root.val);
        }
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if(root == null) return;
        if(root.left == null && root.right == null) result.add(root.val);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }
}