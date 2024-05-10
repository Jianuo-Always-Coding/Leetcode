class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses <= 0) {
            return new int[0];
        }

        Map<Integer, List<Integer>> map = new HashMap<>(); // 记录当前课，和以他为先修课的课都有什么
        int[] nums = new int[numCourses]; // degree统计
        List<Integer> result = new ArrayList<>(); // 路径

        // 统计先修课的数量和更新map
        for (int[] pair : prerequisites) {
            // 记录当前课，和以他为先修课的课都有什么
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<>());
            }
            map.get(pair[1]).add(pair[0]);
            nums[pair[0]]++; // 增加先修课的数量
        }

        //存放所有能上的课
        Queue<Integer> q = new ArrayDeque<>();
        // 先修课为0的课都能上 
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) {
                q.offer(i);
            }
        }

        // 上一个课，把以他为先修课的课程的先修课的数量减1
        while (!q.isEmpty()) {
            int courseNum = q.poll();
            result.add(courseNum);
            if (map.containsKey(courseNum)) {
                for (Integer i : map.get(courseNum)) {
                    nums[i]--;
                    if (nums[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        // 如果课都上完了，那么可以
        if (result.size() == numCourses) {
            int[] resultArr = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                resultArr[i] = result.get(i);
            }
            return resultArr;
        }
        // 不能上完所有的课
        return new int[0];
    }
}
