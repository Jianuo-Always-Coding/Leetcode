class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char s : moves.toCharArray()) {
            if (s == 'R')
                x++;
            else if (s == 'L')
                x--;
            else if (s == 'U')
                y++;
            else if (s == 'D')
                y--;
        }
        return (x == 0) && (y == 0);
    }
}