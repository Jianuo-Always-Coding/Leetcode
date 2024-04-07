class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToOwner = new HashMap<>();
        boolean[] visited = new boolean[accounts.size()];
        Map<Integer, Set<String>> rootToEmails = new HashMap<>(); //result
        // Create a mapping: email - user
        // i is the user index
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) { // j is the index of email
                String email = account.get(j);
                if (!emailToOwner.containsKey(email)) {
                    List<Integer> newList = new ArrayList<>();
                    emailToOwner.put(email, newList);
                }
                emailToOwner.get(email).add(i);
            }
        }
        // System.out.println(emailToOwner.toString());
        // 
        for (Map.Entry<String, List<Integer>> ele : emailToOwner.entrySet()) {
            String email = ele.getKey(); // 1
            List<Integer> users = ele.getValue(); // 1 
            Queue<Integer> q = new ArrayDeque<>();
            Set<String> emails = new TreeSet<>();

            // 把所有的user放进去
            addIdToQueue(users, visited, q);
            // System.out.println(q.toString());

            while (!q.isEmpty()) {
                int id = q.poll();
                List<String> account = accounts.get(id);
                for (int i = 1; i < account.size(); i++) {
                    String subEmail = account.get(i);
                    emails.add(subEmail);
                    List<Integer> subUsers = emailToOwner.get(subEmail);
                    addIdToQueue(subUsers, visited, q);
                    
                }
            }
            // System.out.println(emails.toString());
            // 注意，不为空才能加入
            if (emails.size() != 0) {
                rootToEmails.put(users.get(0), emails);
            }
        }


        // covert to result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> info : rootToEmails.entrySet()) {
            List<String> layer = new ArrayList<>();
            layer.add(accounts.get(info.getKey()).get(0));
            for (String s : info.getValue()) {
                layer.add(s);
            }
            result.add(layer);
        }
        return result;
    }

    private void addIdToQueue(List<Integer> users, boolean[] visited, Queue<Integer> q) {
        for (Integer id : users) {
            if (!visited[id]) {
                q.offer(id);
                visited[id] = true;
            }
        }
    }
}