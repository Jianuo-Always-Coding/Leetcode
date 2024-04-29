class Solution {
    // 求解最小吃香蕉速度
    // 一定可以吃完所有香蕉吗
    // h < n???
    public int minEatingSpeed(int[] piles, int h) {
        // 找到香蕉堆中最大的数量
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        // 初始化二分搜索的左右边界
        int left = 1, right = max;
        // 二分搜索
        while (left < right) {
            int mid = left + (right - left) / 2; // 计算中间值
            int target = eatSpeed(piles, mid); // 计算以当前速度吃香蕉所需的时间
            if (target > h) { // 如果所需时间大于给定的时间，则当前速度太慢，缩小搜索范围
                left = mid + 1;
            } else if (target <= h) { // 如果所需时间小于等于给定的时间，则当前速度可能过快或刚好满足条件，继续缩小搜索范围
                right = mid;
            }
        }
        // 返回最小吃香蕉速度
        return left;
    }

    // 计算以给定速度吃香蕉所需的时间
    public int eatSpeed(int[] piles, int s) {
        int res = 0;
        for (int pile : piles) {
            int hr = pile / s; // 计算吃完当前堆所需的小时数
            int mod = pile % s; // 计算剩余的香蕉数量
            res += mod == 0 ? hr : hr + 1; // 如果剩余数量为0，则不需要额外的小时数，否则需要额外一小时
        }
        return res; // 返回总小时数
    }
}