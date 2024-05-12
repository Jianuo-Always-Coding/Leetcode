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
        public int pathSum(TreeNode root, int sum) {
        HashMap<Long, Integer> preSum = new HashMap(); // 记录prefix sum，sum的值和出现次数
        preSum.put(0L,1);
        return helper(root, (long)0, sum, preSum);
    }
    
    public int helper(TreeNode root, long currSum, int target, HashMap<Long, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        // 只是求出了到达root的时候的result
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        // 往左走和往右走
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1); // 不影响其他路径，删除
        return res;
    }
}
