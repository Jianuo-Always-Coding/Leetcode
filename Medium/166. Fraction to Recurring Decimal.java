class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // corner case
        long nume = numerator;
        long denomin = denominator;
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        nume = Math.abs(nume);
        denomin = Math.abs(denomin);
        long integerNumber = nume / denomin;
        long rest = nume % denomin ;
        rest = rest * 10;
        // System.out.println(rest);
        
        sb.append(integerNumber + "");
        if (rest == 0) {
            return sb.toString();
        } 
        sb.append("."); 
        Map<Long, Integer> map = new HashMap<>();
        while (rest > 0) {
            System.out.println(rest);
            if (map.containsKey(rest)) {
                sb.insert(map.get(rest), "(");
                sb.append(")");
                return sb.toString();

            }
            if (rest / denomin == 0) {
                sb.append("0");
                rest = rest * 10;
                continue;
            } 
            
            map.put(rest, sb.length());
            sb.append(rest / denomin);
            rest = (rest % denomin) * 10;

        }
        return sb.toString();

    }
}