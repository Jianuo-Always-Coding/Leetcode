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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // corner case
        if(root == null) {return new ArrayList<>();}
        Map<Integer, List<Integer>> map = new HashMap<>(); //<col, [node values]>  // 存放这一列 和其中的数据
        Queue<NodeAndCol> q = new LinkedList<>(); //for BFS

        int min = 0; // 最后遍历，存入result使用
        int max = 0; // 最后遍历，存入result使用

        q.offer(new NodeAndCol(root, 0)); // root的col设置为0
        while(!q.isEmpty()) {
            // 看一下这个点
            NodeAndCol cur = q.poll();
            int col = cur.col;
            TreeNode t = cur.node;

            // 没有的话加入新列
            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());

            } 
            map.get(col).add(t.val);
            


            // 更新边界
            if(t.left != null) {
                min = Math.min(min, col -1);
                q.offer(new NodeAndCol(t.left, col-1));
            }
            if(t.right != null) {
                max = Math.max(max, col +1);
                q.offer(new NodeAndCol(t.right, col + 1));
            }

        }
        // 加入结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i<=max; i++) {
            res.add(map.get(i));
        }

        return res;
    }
    // 定义一个 新的数据结构，包括这个点和他的列
    class NodeAndCol {
        TreeNode node;
        int col;

        NodeAndCol(TreeNode t, int col) {
            this.node = t;
            this.col = col;
        }
    }
}
