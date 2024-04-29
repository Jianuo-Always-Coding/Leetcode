class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0 || digits == null){
            return result;
        }
        StringBuilder sb = new StringBuilder();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        backtrack(result, sb, digits, 0, map);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String digits, int index, Map<Character, String> map){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for(int i = 0; i < letters.length(); i++){
            char letter = letters.charAt(i);
            sb.append(letter);
            backtrack(result, sb, digits, index+1, map);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}