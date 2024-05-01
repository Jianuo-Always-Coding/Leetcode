class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++){
            // 移动i直到不同
            if (i !=0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length - 2; j++){
                // 移动j直到不同
                if (j !=i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                long sum = (long)target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    if (sum < nums[left] + nums[right]){
                        right--;
                    }
                    else if (sum > nums[left] + nums[right]){
                        left++;
                    }else{
                        ArrayList<Integer> tem = new ArrayList<Integer>();
                        tem.add(nums[i]);
                        tem.add(nums[j]);
                        tem.add(nums[left]);
                        tem.add(nums[right]);
                        res.add(tem);
                        left++;
                        right--;
                        // 找到就移动left
                        while(left < right && nums[left] == nums[left-1]){
                            left ++;
                        }
                    }
                }
            }
        }
        return res;
    }
}