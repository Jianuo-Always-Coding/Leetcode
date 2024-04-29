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
    // 主函数，返回给定二叉树的边界节点值列表
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // 结果列表
        List<Integer> result = new ArrayList<>();
        // 若根节点为空，直接返回空列表
        if(root == null) return result;
        // 添加根节点的值到结果列表
        result.add(root.val);
        // 添加左边界节点值到结果列表
        addLeftBoundary(root.left, result);
        // 添加左子树的叶子节点值到结果列表
        addLeaves(root.left, result);
        // 添加右子树的叶子节点值到结果列表
        addLeaves(root.right, result);
        // 添加右边界节点值到结果列表
        addRightBoundary(root.right, result);
        // 返回结果列表
        return result;
    }

    // 辅助函数，递归添加左边界节点值到结果列表
    private void addLeftBoundary(TreeNode root, List<Integer> result) {
        // 若节点为空，直接返回
        if(root == null) return;
        // 若节点有左子节点，添加当前节点值到结果列表，并继续向左遍历
        if(root.left != null) {
            result.add(root.val);
            addLeftBoundary(root.left, result);
        } else if(root.right != null) {
            // 若节点只有右子节点，添加当前节点值到结果列表，并继续向右遍历
            // 不确定右子节点是否有左边界节点，所以需要继续添加左边界
            result.add(root.val);
            addLeftBoundary(root.right, result);
        }
    }

    // 辅助函数，递归添加右边界节点值到结果列表
    private void addRightBoundary(TreeNode root, List<Integer> result) {
        // 若节点为空，直接返回
        if(root == null) return;
        // 若节点有右子节点，继续向右遍历并添加当前节点值到结果列表
        if(root.right != null) {
            addRightBoundary(root.right, result);
            result.add(root.val);
        } else if(root.left != null) {
            // 若节点只有左子节点，继续向左遍历并添加当前节点值到结果列表
            // 不确定左子节点是否有右边界节点，所以需要继续添加右边界
            addRightBoundary(root.left, result);
            result.add(root.val);
        }
    }

    // 辅助函数，递归添加叶子节点值到结果列表
    private void addLeaves(TreeNode root, List<Integer> result) {
        // 若节点为空，直接返回
        if(root == null) return;
        // 若节点为叶子节点，添加其值到结果列表
        if(root.left == null && root.right == null) result.add(root.val);
        // 递归向左子树添加叶子节点值
        addLeaves(root.left, result);
        // 递归向右子树添加叶子节点值
        addLeaves(root.right, result);
    }
}