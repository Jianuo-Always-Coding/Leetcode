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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // corner case
        if (preorder == null || preorder.length == 0) {
            return new TreeNode();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return reStructure(preorder, inorder, map, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode reStructure(int[] preorder, int[] inorder, Map<Integer, Integer> map, int left, int right, int leftIn, int rightIn) {
        // base case
        if (left > right) {
            return null;
        }

        TreeNode newNode = new TreeNode(preorder[left]);
        int index = map.get(preorder[left]);
        int leftCount = index - leftIn;
        newNode.left = reStructure(preorder, inorder, map, left + 1, left + leftCount, leftIn, index - 1);
        newNode.right = reStructure(preorder, inorder, map, left + leftCount + 1, right,index + 1, rightIn);
        return newNode;
    }
}