class Solution {
    public String reverseWords(String s) {
        // corner case
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] array = s.toCharArray();
        reverse(array, 0, s.length() - 1);
        int index = 0;
        int n = array.length;
        while (index < array.length) {
            while (index < array.length && array[index] == ' ') {
                index++;
            }
            int start = index++;
            while (index < array.length && array[index] != ' ') {
                index++;
            }
            reverse(array, start, index - 1);
        }

        return simplyString(array);
    }

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