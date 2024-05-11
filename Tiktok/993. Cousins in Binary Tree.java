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
    public boolean isCousins(TreeNode root, int x, int y) {
        // 使用BFS
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean xExist = false; // 记录这一层出现过x吗
            boolean yExist = false;  // 记录这一层出现过y吗

            for (int i = 1; i <= size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == x) {
                    xExist = true;
                }
                if (cur.val == y) {
                    yExist = true;
                }
                // 如果x和y拥有同一个父节点，返回false
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) || (cur.left.val == y && cur.right.val == x)) {
                        return false;
                    }
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (xExist && yExist) {
                    return true;
                }
            }

        }
        return false;
    }
}
