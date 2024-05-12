class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // corner case
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        // 存放小行星的序列
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            Boolean add = true;
            // 一定是现在是右面，之前是左面碰撞
            while (!stack.isEmpty() && asteroid < 0 && stack.peekFirst() > 0) {
                if (Math.abs(asteroid) > Math.abs(stack.peekFirst())) {
                    stack.pollFirst();
                    // 都消失
                } else if (Math.abs(asteroid) == Math.abs(stack.peekFirst())) {
                    stack.pollFirst();
                    add = false;
                    break;
                } else {
                    add = false;
                    break;
                }
            }
            if (add) {
                stack.offerFirst(asteroid);
            }
        }

        // System.out.println(stack.toString());
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pollFirst();
        }
        return result;
    }
}
