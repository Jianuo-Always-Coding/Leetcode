class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> DP = new ArrayList<>();

        if (numRows == 0) return DP;

        // initialization
        DP.add(new ArrayList<Integer>());
        DP.get(0).add(1); // 把1放进去

        // recursion
        // 第i行有i个数
        for (int i = 1; i < numRows; i++) {
            DP.add(new ArrayList<Integer>());
            for (int j = 0; j <= i; j++) {
                // 第1个和最后一个是1
                if (j == 0 || j == i)
                    DP.get(i).add(1);
                else
                    DP.get(i).add(DP.get(i - 1).get(j - 1) + DP.get(i - 1).get(j));
            }
        }
        return DP;
    }
}