public class Solution {
    public int findPeakElement(int[] nums) {
        // check ： 只有一个元素，一边倒
        // peak会不会存在相等的情况
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int mid = (l + r) / 2; //mid 会指向小的一边
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid;
        }
        if (nums[l] > nums[r]) {
            return l;
        }
        return r;
    }
}