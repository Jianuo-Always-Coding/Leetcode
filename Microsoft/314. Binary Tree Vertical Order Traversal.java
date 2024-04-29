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
        if(root == null) {return new ArrayList<>();}
        Map<Integer, List<Integer>> map = new HashMap<>(); //<col, [node values]>
        Queue<NodeAndCol> q = new LinkedList<>(); //for BFS

        int min = 0;
        int max = 0;

        q.offer(new NodeAndCol(root, 0)); // root的col设置为0
        while(!q.isEmpty()) {
            NodeAndCol cur = q.poll();
            int col = cur.col;
            TreeNode t = cur.node;

            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());

            } 
            map.get(col).add(t.val);
            

            if(t.left != null) {
                min = Math.min(min, col -1);
                q.offer(new NodeAndCol(t.left, col-1));
            }
            if(t.right != null) {
                max = Math.max(max, col +1);
                q.offer(new NodeAndCol(t.right, col + 1));
            }

        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i<=max; i++) {
            res.add(map.get(i));
        }

        return res;



    }

    class NodeAndCol {
        TreeNode node;
        int col;

        NodeAndCol(TreeNode t, int col) {
            this.node = t;
            this.col = col;
        }
    }
}