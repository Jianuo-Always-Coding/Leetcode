class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1; // 目标基因不在基因库中，无法变换
        }

        char[] choices = { 'A', 'C', 'G', 'T' };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations; // 找到目标基因，返回变换次数,就是最少的
                }

                char[] currentArray = currentGene.toCharArray();
                // 对于每一位尽行变换
                for (int j = 0; j < 8; j++) {
                    char originalChar = currentArray[j];
                    for (char choice : choices) {
                        if ( originalChar == choice) {
                            continue;
                        }
                        currentArray[j] = choice;
                        String newGene = new String(currentArray);
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                    currentArray[j] = originalChar;
                }
            }
            mutations++; // 每次循环表示一次变换步骤
        }

        return -1; // 无法找到变换路径
    }
}