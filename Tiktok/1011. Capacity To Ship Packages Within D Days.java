class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 货物不能改变运送顺序
        int maxLoad = 0; // 记录最大货物多重
        int totalLoad = 0; // 总共多重
        for (int weight: weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        int left = maxLoad;
        int right = totalLoad;
        while (left < right) {
            int mid =  left + (right - left) / 2;
            if (helper(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean helper(int[] weights, int load, int days) {
        // 计算需要的天数
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > load) {
                daysNeeded ++;
                currentLoad = weight;
            }
        }
        return daysNeeded <= days;
    }
    
}
