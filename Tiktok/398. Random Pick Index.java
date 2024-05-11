class Solution {
    int[] nums;
    Map<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        map = new HashMap<Integer, List<Integer>>();
        rand=new Random();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int randIndex = rand.nextInt(list.size());
        return list.get(randIndex);
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
