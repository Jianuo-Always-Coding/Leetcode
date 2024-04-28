class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // 99 * 99 -> 小于10000 ，m + n够了
        
        // Step 1: Iterate through each digit of num1 and num2 in reverse order
        // 从最后一位开始计算
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add the current product to the current position
                
                // Step 2: Handle the carry
                result[i + j] += sum / 10;
                result[i + j + 1] = sum % 10;
            }
        }
        
        // Step 3: Convert the result array to a string, removing any leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }
        
        // Step 4: Return the final result
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
