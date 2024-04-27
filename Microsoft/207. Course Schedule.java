class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>(); // 记录当前课，和以他为先修课的课都有什么
        int[] nums = new int[numCourses]; //记录先修课的数量
        int count = 0; // 记录上课的数量

        // 统计先修课的数量和更新map
        for (int i = 0; i < prerequisites.length; i++) {
            nums[prerequisites[i][0]]++; // 增加先修课的数量
            if (!map.containsKey(prerequisites[i][1])) { // 没记录过，新加一个list
                map.put(prerequisites[i][1], new ArrayList<>()); 
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new ArrayDeque<>(); //存放所有能上的课
        
        // 先修课为0的课都能上 
        for (int i = 0; i < numCourses; i++) {
            if (nums[i] == 0) {
                q.offer(i);
                count++;
            }
        }

        // 上一个课，把以他为先修课的课程的先修课的数量减1
        while (!q.isEmpty()) {
            int course = q.poll();
            if (map.containsKey(course)) {
                for (Integer n : map.get(course)) {
                    nums[n]--;
                    if (nums[n] == 0) {
                        q.offer(n);
                        count++;
                    }
                }
            }
        }
        // 如果上课的数量等于课程数量 都上完了
        if (count == numCourses) {
            return true;
        }
        return false;
    }
}