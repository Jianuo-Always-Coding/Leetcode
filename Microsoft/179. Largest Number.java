class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator to compare two strings as integers
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Compare in descending order
            }
        };

        // Sort the strings
        Arrays.sort(arr, comparator);

        // Handle edge case where all elements are 0
        if (arr[0].equals("0")) {
            return "0";
        }

        // Concatenate sorted strings to form the largest number
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}