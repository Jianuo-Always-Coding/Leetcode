class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();

        int totalLength=a+b+c;
        int continuousA=0,continuousB=0,continuousC=0;
        for(int i=0;i<totalLength;i++){
            // 先判断是不是最多的
            if(a > 0 && ((a>=b && a>=c && continuousA!=2)||(continuousB==2 && a>=c) ||(continuousC==2 && a>=b))){
                sb.append("a");
                a--;
                continuousA++;
                continuousB=0;
                continuousC=0;
            }else if(b > 0 && ((b>=a && b>=c && continuousB!=2)||(continuousA==2 && b>=c) ||(continuousC==2 && b>=a))){
                sb.append("b");
                b--;
                continuousB++;
                continuousA=0;
                continuousC=0;
            }else if(c > 0 && ((c>=b && c>=a && continuousC!=2)||(continuousB==2 && c>=a) ||(continuousA==2 && c>=b))){
                sb.append("c");
                c--;
                continuousC++;
                continuousB=0;
                continuousA=0;
            }
        }
        return sb.toString();
    }
}
