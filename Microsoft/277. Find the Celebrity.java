/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        // 因为名人不认识其他人
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        // 所以candidate 一定是名人
        // 但是最后i =  n - 1的时候也会
        // 验证
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}