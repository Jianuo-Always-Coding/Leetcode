class Solution {
        public static int romanToInt(String s) {
            if(s == null) {
                return 0;
            }

            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int result = 0;

            
            for(int i = 0; i < s.length(); i++) {  // "MCMXCIV"
                if(s.charAt(i) == 'I' && i < s.length() - 1) {
                    if(s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
                        result = result - map.get('I');
                        i++;
                    }
                        
                }
                if(s.charAt(i) == 'X' && i < s.length() - 1) {
                    if(s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
                        result = result - map.get('X');
                        i++;
                    }
                }
                if(s.charAt(i) == 'C' && i < s.length() - 1) {
                    if(s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
                        result = result - map.get('C') ;
                        i++;
                    }
                }

                result += map.get(s.charAt(i));
            }
            return result;
        }
}