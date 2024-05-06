class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            return findKthElement(nums1, nums2, totalLength / 2 + 1); // 找到第totalLength / 2 + 1大的
        } else {
            // 找到第totalLength / 2 和 第totalLength / 2 + 1大的 除2
            return (findKthElement(nums1, nums2, totalLength / 2) + findKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }
    
    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int left1 = 0, left2 = 0; // 找到了的数量
        while (true) {
            // 如果一个超界
            if (left1 == nums1.length) {
                return nums2[left2 + k - 1];
            }
            if (left2 == nums2.length) {
                return nums1[left1 + k - 1];
            }
            // 找到了
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            
            // 找二分之一
            int half = k / 2;
            // left1 和 left2表示找到的数量，所以index需要减去1
            int newLeft1 = Math.min(left1 + half, nums1.length) - 1;
            int newLeft2 = Math.min(left2 + half, nums2.length) - 1;
            if (nums1[newLeft1] <= nums2[newLeft2]) {
                k -= (newLeft1 + 1 - left1); // 找到的数量是 （newLeft1 + 1） - left1
                left1 = newLeft1 + 1;
            } else {
                k -= (newLeft2 + 1 - left2); // 找到的数量是 （newLeft2 + 1） - left2
                left2 = newLeft2 + 1;
            }
        }
    }
}
