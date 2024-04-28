class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> result = new ArrayList<>(); // 存放结果
        int len = 0; 
        int wordCount = 0;
        int start = 0; // 记录第一个单词的位置

        while (start < n) {
            len = words[start].length();
            int end = start + 1;
            // 是否能放下一个单词加一个空格
            while (end < n && 1 + len + words[end].length() <= maxWidth) {
                len = 1 + len + words[end].length();
                end++;
            }
            // 如果最后一行
            if (end == n) {
                addLast(words, start, result, maxWidth);
            } else {
            // 不是最后一个行
                addToResult(words, start, end - 1, result, maxWidth, len);
            }
            start = end;
        }
        return result;
    }

    //最后一行末尾补空格
    private void addLast(String[] words, int start, List<String> result, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < words.length; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        if (sb.length() > maxWidth) {
            sb.deleteCharAt(sb.length() - 1);
        } else if (sb.length() < maxWidth) {
            int size = maxWidth - sb.length();
            for (int i = 0; i < size; i++) {
                sb.append(" ");
            }
        }
        result.add(sb.toString());
    } 

    // 不是最后一行中间加入空格
    private void addToResult(String[] words, int start, int end, List<String> result, int maxWidth, int len) {
        StringBuilder sb = new StringBuilder();
        int count = end - start + 1; // 一共有几个单词
        if (count == 1) {
            sb.append(words[start]);
            int size = maxWidth - sb.length();
            for (int i = 0; i < size; i++) {
                sb.append(" ");
            }
            result.add(sb.toString());
            return ;
        }
        int spaceNeedBasic = (maxWidth - len) / (count - 1) + 1;
        int extraSpace = (maxWidth - len) % (count - 1);
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                for (int j = 0; j < spaceNeedBasic; j++) {
                    sb.append(" ");
                }
                if (extraSpace > 0) {
                    sb.append(" ");
                    extraSpace--;
                }
            }
        }
        result.add(sb.toString());
    }
    
}