class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // 使用两个双端队列来维护当前子数组的最小值和最大值
        LinkedList<Integer> min = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        
        // 初始化左右指针
        int i = 0;
        int j = 0;
        
        // 遍历数组
        while (j < nums.length) {
            int n = nums[j];
            
            // 维护最小值队列，移除队尾小于当前元素的值
            while (!min.isEmpty() && min.peekLast() > n) {
                min.removeLast();
            }
            
            // 维护最大值队列，移除队尾大于当前元素的值
            while (!max.isEmpty() && max.peekLast() < n) {
                max.removeLast();
            }
            
            // 将当前元素添加到最小值和最大值队列的队尾
            min.addLast(n);
            max.addLast(n);
            
            // 如果当前子数组的最大值与最小值之差大于限制值
            if (max.peekFirst() - min.peekFirst() > limit) {
                // 移除左指针对应的元素，并更新左指针位置
                if (min.peekFirst() == nums[i]) min.removeFirst();
                if (max.peekFirst() == nums[i]) max.removeFirst();
                i++;
            }
            // 移动右指针
            j++;
        }
        // 返回最长子数组的长度
        return j - i;
    }
}