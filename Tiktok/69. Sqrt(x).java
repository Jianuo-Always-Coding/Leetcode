class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1) return x;
        
        int left=1, right=x;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            // 乘法转成除法
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 最终返回right，因为如果left变成比结果大于一，right就变成结果
        return right;
    }
}
