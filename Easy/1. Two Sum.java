class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int restVal = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(restVal), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}