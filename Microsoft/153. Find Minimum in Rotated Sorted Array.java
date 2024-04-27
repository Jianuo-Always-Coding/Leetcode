class Solution {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;

    while (l < r) {
      int m = (l + r) / 2;
      // 只有mid比right小才能移动右指针，而且mid可能指向result，所以为right = mid
      if (nums[m] < nums[r])
        r = m;
      else
        l = m + 1;
    }

    return nums[l];
  }
}