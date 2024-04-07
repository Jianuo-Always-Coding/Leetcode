class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // corner case
        int[] result = new int[numCourses];
        int index = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        Queue<Integer> q = new ArrayDeque<>();
        for (int[] pair : prerequisites) {
            int prev = pair[1];
            int cur = pair[0];
            count[cur]++;
            if (!map.containsKey(prev)) {
                map.put(prev, new ArrayList<>());
            }
            map.get(prev).add(cur);
        }

        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }


        while (!q.isEmpty()) {
            int c = q.poll();
            result[index++] = c;

            if (map.get(c) == null) {
                continue;
            }

            List<Integer> list = map.get(c);
            for (int i : list) {
                count[i]--;
                if (count[i] == 0) {
                    q.offer(i);
                }
            }
        }

        if (index == numCourses) {
            return result;
        }
        return new int[0];

    }
}