class Solution {


    public int maxValue(int n, int index, int maxSum) {
        long left = 1; 
        long right = maxSum; // 记录可能到达的高度

        while (left < right) {
            long mid = right - (right - left) / 2; // 避免死循环，虽然left = 0不会出现
            if (count(mid, n, index) <= (long)maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }

    private long count (long h, int n, int index) {
        long sum = 0;
        // 计算前面
        // 左面没有从1开始
        if (h > index) {
            // （首项 + 末项）* 项数 / 2
            sum = (h - index + h) * (index + 1)  / 2;
        } else {
            // 前面还有若干个1
            sum = index - h + 1;
            sum += (1 + h) * h / 2;
        }

        // 计算后面
        if (h > n - index) {
            sum += (h - (n - index) + 1 + h) * (n - index) / 2;
        } else {
            sum += n - (index + h);
            sum += (1 + h) * h / 2;
        }
        return (long)(sum - h); // 因为h计算了两遍
    }
}
