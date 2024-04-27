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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root!=null) searchBT(root, "", res);
        return res;
    }

    private void searchBT(TreeNode root, String path, List<String> res){
        // 叶子结点，加入最后一个数，加入结果
        if(root.left==null && root.right==null) res.add(path + root.val);
        if(root.left!=null) searchBT(root.left, path+root.val+"->", res);
        if(root.right!=null) searchBT(root.right, path+root.val+"->", res);
    }
}