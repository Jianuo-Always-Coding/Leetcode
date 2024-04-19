class Solution {
    public int[][] merge(int[][] intervals) {
        int[] array = new int[10001];
        int[] single = new int[10001];

        for (int[] pair : intervals) {
            if (pair[0] == pair[1]) {
                single[pair[0]] = 1;
            } else {
                array[pair[0]]++;
                array[pair[1]]--;
            }
        }

        List<int[]> list = new ArrayList<>();
        int index = 0;
        int sum = 0;

        while (index <10001) {
            sum += array[index];
            if (sum > 0) {
                int start = index++;
                while (sum > 0) {
                    sum += array[index++];
                }
                int end = index - 1;
                list.add(new int[] {start, end});
            } else if (single[index] == 1) {
                list.add(new int[] {index, index});
                index++;
            } else {
                index++;
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}