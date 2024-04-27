class Solution {
    public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] array = s.toCharArray();
        // 总体reverse一下
        reverse(array, 0, s.length() - 1);
        int index = 0;
        int n = array.length;
        // 分别对每一个单词reverse，但是不确定其中有多少个空格
        while (index < array.length) {
            // 找到第一个不是空格的
            while (index < array.length && array[index] == ' ') {
                index++;
            }
            int start = index; // start 是第一个不是空格的
            // index是下一个空格或者边界index + 1
            while (index < array.length && array[index] != ' ') {
                index++;
            }
            reverse(array, start, index - 1);
        }

        return simplyString(array);
    }

    // 只能保留一个空格
    private String simplyString(char[] array) {
        int index = 0;
        boolean seenSpace = true;
        int cur = 0;
        while (index < array.length) {
            if (array[index] != ' ') {
                seenSpace = false;
                array[cur++] = array[index++];
            } else {
                if (seenSpace) {
                    index++;
                } else {
                    array[cur++] = array[index++];
                    seenSpace = true;
                }
            }
        }
        if (cur > 0 && array[cur - 1] == ' ') {
            cur--;
        }
        return new String(array, 0, cur);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}