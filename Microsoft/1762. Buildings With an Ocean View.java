class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>(); // 因为不知道结果有多少，所以先用一个list存储
        int max = 0;
        // 从右面看到左面
        for(int i=heights.length-1; i>=0; i--) {
            // 如果比右面所有的都高，那么加入result，更新max
            if(heights[i] > max) list.add(i);
            max = Math.max(max, heights[i]);
        }
        // 整理结果
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i] = list.get(list.size()-1-i);
        return result;
    }
}