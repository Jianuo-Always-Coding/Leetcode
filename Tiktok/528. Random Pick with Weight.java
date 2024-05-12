class Solution {
    // 使用prefix sum和binary search结合
    int[] prefixSum;
    Random random;

    public Solution(int[] w) {
        // 初始化累加和数组
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

        random = new Random();
    }
    
    public int pickIndex() {
        int randomVal = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;
        // 随机挑选一个数，然后根据值选择区间
        int l = 0;
        int r = prefixSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (randomVal > prefixSum[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
