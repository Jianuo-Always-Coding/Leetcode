class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        int right = 0;
        char[] array = s.toCharArray();
        int rightUsed = 0;
        int canAddRight = 0;

        while (right < array.length) {
            if (array[right] == '(') {
                // find right after max(rightUsed, right)
                int rightParaIndex = Math.max(right + 1, rightUsed + 1);
                while (rightParaIndex < array.length) {
                    if (array[rightParaIndex] != ')') {
                        rightParaIndex++;
                    } else {
                        break;
                    }
                }
                // 说明没有右括号了
                if (rightParaIndex == array.length) {
                    while (right < array.length) {
                        if (array[right] == '(') {
                            right++;
                        } else {
                            array[left++] = array[right++]; 
                        }
                    }
                    return new String(array, 0, left);
                } else {
                    // 找到右括号了
                    rightUsed = rightParaIndex;
                    canAddRight++;
                    array[left++] = array[right++]; 
                }
            } else if (array[right] == ')') {
                if (canAddRight > 0) {
                    canAddRight--;
                    array[left++] = array[right++]; 
                } else {
                    // remove
                    right++;
                }
                
            } else {
                // add to result
                array[left++] = array[right++]; 
            }
        }
        return new String(array, 0, left);
    }

}