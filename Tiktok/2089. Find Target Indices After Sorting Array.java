class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 统计这个数出现了多少此,比这个数小的有多少个
        int count=0, lessthan=0;
        for(int n:nums){
            if(n==target) count++;
            if(n< target) lessthan++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<count; i++){
            res.add(lessthan++);
        }
        return res;
    }
}
