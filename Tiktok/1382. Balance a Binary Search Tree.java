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
    // 先把Tree使用inorder的方式展开，然后使用binarysearch的方式重建
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>(); //存放sorted的结果
        inorderTraverse(root, list);
        return sortedArrayToBST(list, 0, list.size() - 1);
    }

    private void inorderTraverse(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return ;
        }

        inorderTraverse(root.left, list);
        list.add(root);
        inorderTraverse(root.right, list);
    }

    TreeNode sortedArrayToBST(List<TreeNode> list, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = list.get(mid);
        root.left = sortedArrayToBST(list, start, mid - 1);
        root.right = sortedArrayToBST(list, mid + 1, end);
        return root;
    }
}
