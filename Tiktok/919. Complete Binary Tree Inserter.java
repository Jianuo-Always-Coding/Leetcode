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
class CBTInserter {

    Queue<TreeNode> q = new LinkedList<>(); // 存放他下面还能放入点的点
    TreeNode ptr = new TreeNode(); // 第一个能放的点
    TreeNode root;

    // construcor
    public CBTInserter(TreeNode root) {
        this.root = root;

        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll();

            // 还有地方放
            if (temp.left == null || temp.right == null)
                q.offer(temp);

            // 孩子也要放进去
            if (temp.left != null)
                que.offer(temp.left);
            // 孩子也要放进去i
            if (temp.right != null)
                que.offer(temp.right);

        }

        ptr = q.peek();
    }

    public int insert(int val) {
        int ans = ptr.val;

        if (ptr.left == null) {
            TreeNode newNode = new TreeNode(val);

            ptr.left = newNode;

            q.offer(newNode);
        } else {
            // 放满了，需要把这个点移除，然后将新点加入
            TreeNode newNode = new TreeNode(val);

            ptr.right = newNode;

            q.poll();

            q.offer(newNode);

            ptr = q.peek();
        }
        return ans;
    }

    public TreeNode get_root() {
        return root;
    }
}
/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
