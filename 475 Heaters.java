//  暴力解
class Solution1 {
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;

        for (int i = 0; i < houses.length; i++) {
            int bestSolution = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                bestSolution = Math.min(Math.abs(houses[i] - heaters[j]), bestSolution);
            }
            radius = Math.max(radius, bestSolution);
        }
        return radius;
    }
}

// binary search
class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int houseIndex = 0;
            int heaterIndex = 0;

            // 看是否所有房子都能被加热
            while (heaterIndex < heaters.length && houseIndex < houses.length) {
                // 左面加热不到一定加热不到
                if (heaters[heaterIndex] - mid > houses[houseIndex]) {
                    break;
                } 
                
                // 左面能加热到，就说明如果没有加热到一定是在右面
                // 右面没加热到，换下一个heater，看左，看右
                if (heaters[heaterIndex] + mid < houses[houseIndex]) {
                    heaterIndex++;
                } else {
                    houseIndex++;
                }
            }

            // 如果能遍历所有的房子，说明能加热到，那么right = mid - 1
            // update result
            if (houseIndex == houses.length) {
                right = mid - 1;
                result = mid;
            // 如果遍历不到所有的房子，说明加热不到，left = mid + 1
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}