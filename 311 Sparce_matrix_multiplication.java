class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < mat2.length; i++) {
            map.put(i, new HashMap<Integer, Integer>());
            for (int j = 0; j < mat2[0].length; j++) {
                if (mat2[i][j] != 0) {
                    map.get(i).put(j, mat2[i][j]);
                }    
            }
        }  

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0 && map.get(j) != null) {
                    for (int k : map.get(j).keySet()) { //row is j , col is k
                        result[i][k] += mat1[i][j] * mat2[j][k];
                    }
                }
            }
        }
        return result;
              
    }
}