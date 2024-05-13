class Solution {
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    
    private int[] dfs(TreeNode root,int distance){
        // int[i] means how many leaf nodes are there with the distance of i from the current node
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1] = 1;
            return res;
        }
        int[] left = dfs(root.left,distance);
        int[] right = dfs(root.right,distance);
        for(int l = 0;l<left.length;l++){
            for(int r = 0; r < right.length; r++){
                if(l+r <=distance)
                result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i = 0;i < res.length - 1;i++){
            // return distance i + 1
            res[i+1] = left[i]+right[i];
        }
        
        return res;
    }
}
