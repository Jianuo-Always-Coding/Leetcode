class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 分为几个部分，一符号，二整数，三小数点，四小数，五循环部分
        // corner case
        long nume = numerator;
        long denomin = denominator;
        StringBuilder sb = new StringBuilder();
        // 考虑符号
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        nume = Math.abs(nume);
        denomin = Math.abs(denomin);

        // 添加整数部分
        long integerNumber = nume / denomin;
        long rest = nume % denomin ;
        sb.append(integerNumber);
        
        //结束了直接返回
        if (rest == 0) {
            return sb.toString();
        }

        //存在小数部分 
        sb.append("."); 
        rest = rest * 10;
        Map<Long, Integer> map = new HashMap<>(); // 当前rest是多少，位置是哪个位置

        while (rest > 0) {
            // 找到循环的部分了
            if (map.containsKey(rest)) {
                sb.insert(map.get(rest), "(");
                sb.append(")");
                return sb.toString();
            }
            // 记录一下rest值所对应的位置
            map.put(rest, sb.length());
            if (rest / denomin == 0) {
                sb.append("0");
                rest = rest * 10;
                continue;
            } 
            
            sb.append(rest / denomin);
            rest = (rest % denomin) * 10;

        }
        return sb.toString();

    }
}
