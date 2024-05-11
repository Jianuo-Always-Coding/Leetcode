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
    public class NodeInfo {
        private int max;
        private int min;
        private int size;

        public NodeInfo(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size = size;  
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;

        NodeInfo rootInfo = dfs(root);
        return rootInfo.size;
    }

    private NodeInfo dfs(TreeNode root) {
        if (root == null) return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeInfo leftInfo = dfs(root.left);
        NodeInfo rightInfo = dfs(root.right);
        NodeInfo curInfo = new NodeInfo(0,0,0);
        if (leftInfo.max < root.val && rightInfo.min > root.val) {
            // 合法
            curInfo.max = Math.max(rightInfo.max, Math.max(leftInfo.max, root.val));
            curInfo.min = Math.min(leftInfo.min, Math.min(rightInfo.min, root.val));

            curInfo.size = leftInfo.size + rightInfo.size + 1;
        } else {
            // 不合法，将范围扩大至最大
            curInfo.max = Integer.MAX_VALUE;
            curInfo.min = Integer.MIN_VALUE;
            curInfo.size = Math.max(leftInfo.size, rightInfo.size);
        }

        return curInfo;
    }
}
