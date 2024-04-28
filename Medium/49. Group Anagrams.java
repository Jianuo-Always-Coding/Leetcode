class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Convert the string to char array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Add the sorted string to the map and group anagrams together
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            anagramGroups.get(sortedStr).add(str);
        }

        // Convert map values to list and return
        return new ArrayList<>(anagramGroups.values());
    }
}