class Solution {

    public boolean isBipartite(int[][] arr) {
        int n = arr.length;

        int[] color = new int[n];  // this willv also act as the visited array
        Arrays.fill(color,-1);

        for(int i=0; i<n; i++){
            // 没访问过
            if(color[i]==-1){
                if(!bfs(arr,i,color)) return false;
            }
        }
        return true;
    }

    static boolean bfs(int arr[][], int src, int color[]){
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>(); // 存放需要遍历节点的index
        q.add(src); // 起始放进去
        color[src] = 0; // 定义一种颜色

        while(q.size()!=0){
            int a = q.poll();
            int col = color[a];
            // 便利所有他的邻居
            for(var x : arr[a]){
                // 没见过，给颜色
                if(color[x]==-1){
                    color[x] = (col==1) ? 0 : 1;
                    q.offer(x);
                }else{
                    // 见过，判断颜色是否匹配
                    if(color[x]==col) return false;
                }
            }
        }
        return true;
    }
    
}