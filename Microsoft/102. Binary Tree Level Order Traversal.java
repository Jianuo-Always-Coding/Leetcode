/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

 // assumption: root == null -> return new ArrayList<>();

//        5
//       / \
//      4   6
//    /  \   \
//    8   9   1

// q  size 3
// layer 8 9 1
// result [[5],[4, 6],[8,9,1]]
public class Solution {
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    // corner case
    if (root == null) {
      return result;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.offer(root);

    while (!q.isEmpty()) {

      List<Integer> layer = new ArrayList<>();
      int size = q.size();
      for (int i = 1; i <= size; i++) {
        TreeNode cur = q.poll();
        layer.add(cur.key);
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
      }
      result.add(layer);
    }
    return result;
  }
}

// time complexity : O(n)
// space complaxity : stack : O(1) heap: O(n)
