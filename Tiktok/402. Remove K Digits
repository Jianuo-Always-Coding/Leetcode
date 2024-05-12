class Solution {
    public String removeKdigits(String num, int k) {
    	char[] arr = num.toCharArray();
        int n = arr.length;
        int pos = -1;
        int len = n - k;
        if (n <= k) {
        	return "0";
        }

        // 维护一个单调递增栈
        for (int i = 0; i < n; i++) {
            while (pos >= 0 && k > 0 && arr[i] < arr[pos]) {
                pos--;
                k--;
            }
            arr[++pos] = arr[i];

        }
        // 去处前置的0
        int start = 0;
        while (start < len - 1 && arr[start] == '0') {
            start++;
        }
        
        return String.valueOf(arr, start, len - start);
    }
}
