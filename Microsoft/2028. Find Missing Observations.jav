class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // n是否为0
        int m = rolls.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += rolls[i];
        }
        // 找到丢失的数量是多少
        int x = (mean * (m + n)) - sum;
        // x小于n,每个不足1，
        // x大于所有为6，比n小
        if (x < n || n * 6 < x) {
            return new int[] {};
        }

        int arr[] = new int[n];
        // p为基础，q为还有多少个需要加一
        int p = x / n, q = x % n;
        for (int i = 0; i < n; i++) {

            arr[i] = p + (q > 0 ? 1 : 0);
            q--;
        }
        return arr;
    }
}