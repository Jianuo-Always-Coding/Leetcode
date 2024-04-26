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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // corner case
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        boolean flag = false; // true is for odd level read from right, false is for even level read from left

        while (!deque.isEmpty()) {
            if (flag) {
                readFromRight(deque, result);
            } else {
                readFromLeft(deque, result);
            }
            flag = !flag;
        }
        return result;
    }

    private void readFromRight(Deque<TreeNode> deque, List<List<Integer>> result) {
        int size = deque.size();
        List<Integer> layer = new ArrayList<>();
        
        for (int i = 1; i <= size; i++) {
            TreeNode cur = deque.pollLast();
            layer.add(cur.val);

            if (cur.right != null) {
                deque.offerFirst(cur.right);
            }
            if (cur.left != null) {
                deque.offerFirst(cur.left);
            }
        }
        result.add(layer);
    }

    private void readFromLeft(Deque<TreeNode> deque, List<List<Integer>> result) {
        int size = deque.size();
        List<Integer> layer = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            TreeNode cur = deque.pollFirst();
            layer.add(cur.val);

            if (cur.left != null) {
                deque.offerLast(cur.left);
            }
            if (cur.right != null) {
                deque.offerLast(cur.right);
            }
        }
        result.add(layer);

    }
}