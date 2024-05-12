class Solution {
    public int nextGreaterElement(int n) {
        String str = Integer.toString(n);
        char ch[] = str.toCharArray();
        int len = ch.length;

        // 找到第一个不是降序
        int i = len - 2;
        while (i >= 0 && ch[i] >= ch[i + 1]) {
            i--;
        }

        //都是降序,返回-1
        if (i == -1) {
            return -1;
        }
        int k = len - 1;
        // 找到从右面数,第一个比他大的数
        while (ch[i] >= ch[k]) {
            k--;
        }

        // 交换
        char temp = ch[i];
        ch[i] = ch[k];
        ch[k] = temp;

        // 把i左面的都加入
        String sb = "";
        for (int m = 0; m <= i; m++) {
            sb = sb + ch[m];
        }
        //reverse右面的部分加入
        for (int notu = ch.length - 1; notu > i; notu--) {
            sb = sb + ch[notu];
        }

        long number = Long.parseLong(sb.toString());
        return (number <= Integer.MAX_VALUE) ? (int) number : -1;
    }
}
