class Solution {
    public int removeStones(int[][] stones) {
      Set<int[]> visited=new HashSet<>();
      int numOfIslands=0;
      for(int[] s1:stones){
          if(!visited.contains(s1)){
              // 将所有可以连接到一起的点只保留一个
              dfs(s1,visited,stones);
              numOfIslands++;
          }
      }
     return stones.length-numOfIslands;   // 需要移除点的总数为：总点数减去类的个数
    }
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
     visited.add(s1);
     for(int[] s2:stones){
         if(!visited.contains(s2)){
             if(s1[0]==s2[0] || s1[1]==s2[1]){
               dfs(s2, visited, stones);  
             }
         }
     }
    }       
}
