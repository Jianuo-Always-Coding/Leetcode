class Solution {
    public int getSum(int a, int b) {
        // b is 进位carry， a is the result of two numbers add
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}