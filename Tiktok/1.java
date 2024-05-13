class Solution {
    public int minInsertions(String s) {
        int left = 0, res=0;

        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) == '(') left ++;
            else if(i == s.length() - 1 || s.charAt(i + 1) == '(') {
                if(left > 0){
                    res++;
                    left--;
                }
                else {
                    res+=2;
                }
            }else{
                if(left>0){
                    left--;
                }else{
                    res++;
                }
                i++;
            }
        }
        return res+= left*2;
    }
}
