class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k + 1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if (matrix[l1.get(0)][l1.get(1)] == matrix[l2.get(0)][l2.get(1)]) {
                    return 0;
                }
                return matrix[l1.get(0)][l1.get(1)] < matrix[l2.get(0)][l2.get(1)] ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[m][n];
        minHeap.offer(Arrays.asList(0, 0));
        visited[0][0] = true;
        int num = 1;

        while (num < k) {
            List<Integer> tmp = minHeap.poll();
            // down
            if (tmp.get(0) < matrix.length - 1 && !visited[tmp.get(0) + 1][tmp.get(1)]) {
                minHeap.offer(Arrays.asList(tmp.get(0) + 1, tmp.get(1)));
                visited[tmp.get(0) + 1][tmp.get(1)] = true;
            }
            // right
            if (tmp.get(1) < matrix[0].length - 1 && !visited[tmp.get(0)][tmp.get(1) + 1]) {
                minHeap.offer(Arrays.asList(tmp.get(0), tmp.get(1) + 1));
                visited[tmp.get(0)][tmp.get(1) + 1] = true;
            }
            num++;
        }
        List<Integer> result = minHeap.poll();
        return matrix[result.get(0)][result.get(1)];

    }
}