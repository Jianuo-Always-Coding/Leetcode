class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> map = new HashMap<>(); // 《原材料，需要这个原材料的菜》
        Map<String, Integer> indegrees = new HashMap<>(); // 做这个菜需要的原材料的数量 
 
        for (int i = 0; i < recipes.length; i++) {
           indegrees.put(recipes[i], ingredients.get(i).size()); // 记录每一道菜需要的原材料的数量
           for (String ingredient : ingredients.get(i)) {
               map.putIfAbsent(ingredient, new ArrayList<>());
               map.get(ingredient).add(recipes[i]);

           }
        }

        Queue<String> queue = new LinkedList<>();
        // 把所有原材料放进去
        for (String supply : supplies) {
            queue.add(supply);
        }
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (map.containsKey(cur)) {
                for (String next : map.get(cur)) {
                    indegrees.put(next, indegrees.get(next) - 1);
                    if (indegrees.get(next) == 0) {
                        list.add(next);
                        queue.add(next);
                    }
                }

            }
        }
        return list;
    }
}
