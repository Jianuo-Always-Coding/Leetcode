class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        // 将产品数组按字典序排序
        Arrays.sort(products);
        // 初始化左右指针
        int left = 0;
        int right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
             // 移动左指针直到找到与搜索词当前字符匹配的产品或超出右指针范围
             // left和right有记忆
            while (left <= right &&
                    (products[left].length() <= i || products[left].charAt(i) != searchWord.charAt(i))) {
                left++;
            }

            while (left <= right &&
                    (products[right].length() <= i || products[right].charAt(i) != searchWord.charAt(i))) {
                right--;
            }
            List<String> list = new ArrayList<>();

            for (int j = left; j < left + 3 && j <= right; j++) {
                list.add(products[j]);
            }

            ans.add(list);
        }

        return ans;
    }
}
