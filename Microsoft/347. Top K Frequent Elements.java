class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // corner case
        Map<Integer, Integer> map = new HashMap<>();
        for (int s : nums) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        if (e1.getValue().equals(e2.getValue())) {
                            return 0;
                        }
                        return e1.getValue() < e2.getValue() ? -1 : 1;
                    }
                });

        int num = 0;

        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            if (num < k) {
                minHeap.offer(ele);
                num++;
                continue;
            }

            int val = minHeap.peek().getValue();
            if (ele.getValue() > val) {
                minHeap.poll();
                minHeap.offer(ele);
            }
        }

        int[] result = new int[minHeap.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;

    }
}