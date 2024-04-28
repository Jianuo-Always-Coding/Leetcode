class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, cur = 0, ans = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            // 当前加油站能否走到下一个加油站
            if (cur < 0) {
                // 起始变成下一个加油站
                ans = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? ans : -1;
    }
}