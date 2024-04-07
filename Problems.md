P-0 (出现频率5次以上)：
​​23. Merge k Sorted Lists ​​​​​​(hard)：同一个HR小伙伴考了
qishan - 11sde - 381. Insert Delete GetRandom O(1) - Duplicates allowed
93. Restore IP Addresses 
297. Serialize and Deserialize Binary Tree 同一个HR小伙伴考了
55. Jump Game：qishan考了
https://leetcode.com/problems/jump-game/ 

class Solution {
    public boolean canJump(int[] nums) {
        // M[i] represent stand on index i, if we can jump out to the final
        // for i + 1 <= j <= i + A[i], if any A[j] is true, A[i] is the true
        if (nums.length <= 1) {
            return true;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= len - 1) {
                dp[i] = true;
            } else {
                for (int j = nums[i]; j >= 1; j--) {
                    if (dp[i + j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}


45. Jump Game II(qishan) 
https://leetcode.com/problems/jump-game-ii/ 

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
            } else {
                int tmp = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    if (dp[i + j] >= 0) {
                        tmp = Math.min(tmp, dp[i + j]);
                    }
                }
                if (tmp == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = tmp + 1;
                }
            }
        }
        return dp[0]; 
    }
}


56. Merge Intervals
https://leetcode.com/problems/merge-intervals/ 

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            if (intervals[i][0] > last[1]) {
                list.add(intervals[i]);
            } else {
                last[1] = Math.max(last[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}



刚有TT小伙伴面过146. LRU Cache
又有tiktok小伙伴面这道题
https://leetcode.com/problems/lru-cache/ 

class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public void update(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
            append(node);
        } else if (map.size() < capacity) {
            node = new Node(key, value);
            append(node);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
            append(node);
        }
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        node.next = null;
        node.prev = null;
    }
    
    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
}


199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/ 

296. Right View Of Binary Tree 
public class Solution {
  public List<Integer> rightView(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (i == size - 1) {
          result.add(cur.val);
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return result;
  }
}





200. Number of Islands
https://leetcode.com/problems/number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private void dfs(char[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return; 
        }
        
        if (visited[i][j]) {
            return;
        }
        
        if (grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            dfs(grid, nextI, nextJ, rows, cols, visited);
        }
        return;
    }
}



210. Course Schedule II
https://leetcode.com/problems/course-schedule-ii/ 

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for (int[] course : prerequisites) {
            int pre = course[1];
            int cur = course[0];
            indegree[cur]++;
            
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList<>());
            }
            map.get(pre).add(cur);
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            
            if (map.get(cur) != null) {
                for (int nei : map.get(cur)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        queue.offer(nei);
                    }
                }
            }
        }
        
        System.out.println(result.size());
        
        if (result.size() != numCourses) {
            return new int[0];
        }
        return toArray(result);
    }
    
    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}


198. House Robber
https://leetcode.com/problems/house-robber/ 

class Solution {
    public int rob(int[] nums) {
        // dp[i] represent the max profit robber at index i
        // dp[i] rely on current we rob or not
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // if only one element, must rob
        dp[0] = nums[0];
        // if two elements, consifer rob which one
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int robCur = dp[i - 2] + nums[i];
            int notRobCur = dp[i - 1];
            dp[i] = Math.max(robCur, notRobCur);
        }
        return dp[nums.length - 1];
    }
}


213. House Robber II
https://leetcode.com/problems/house-robber-ii/ 

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    private int helper(int[] nums, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return nums[left];
        }
        int pre2 = nums[left];
        int pre = Math.max(nums[left], nums[left + 1]);
        // int cur = 0;
        
        for (int i = left + 2; i <= right; i++) {
            int cur = Math.max(pre, pre2 + nums[i]);
            pre2 = pre;
            pre = cur;
        }
        return pre;
    }
}



TT刚面过 227. Basic Calculator II
https://leetcode.com/problems/basic-calculator-ii/ 

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                nums.push(num);
            } else {
                while (!operators.isEmpty() && getPrecedence(c) <= getPrecedence(operators.peek())) {
                    nums.push(evaluate(operators.pop(), nums.pop(), nums.pop()));
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            nums.push(evaluate(operators.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }
    private int getPrecedence(char c) {
        return c == '+' || c == '-' ? 0 : 1;
    }
    private int evaluate(char operator, int n1, int n2) {
        switch(operator) {
            case '+':
                return n1 + n2;
            case '-':
                return n2 - n1;
            case '*':
                return n1 * n2;
            case '/':
                return n2 / n1;
        }
        return 0;
    }
}



269. Alien Dictionary
https://leetcode.com/problems/alien-dictionary/ 

class Solution {
    public String alienOrder(String[] words) {
        // compare each two word and count its dependency of each word
        // do topology order from each node to check if has a cycle
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = buildGraph(words);
        // 0 - unvisit, 1 - visiting, 2 - visited
        Map<Character, Integer> states = new HashMap<>();
        // Iniatial states
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                states.put(ch, 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        // topological sort check
        for (Character ch : states.keySet()) {
            if (!topologyOrder(graph, states, ch, sb)) {
                return "";
            }
        }
        return sb.reverse().toString();
    }
    
    private boolean topologyOrder(Map<Character, Set<Character>> graph, Map<Character, Integer> states, Character ch, StringBuilder sb) {
        // base case
        Integer state = states.get(ch);
        if (state == 1) {
            return false;
        }
        if (state == 2) {
            return true;
        }
        states.put(ch, 1);
        for (Character nei : graph.get(ch)) {
            if (!topologyOrder(graph, states, nei, sb)) {
                return false;
            }
        }
        states.put(ch, 2);
        sb.append(ch);
        return true;
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        // initial set for each character
        for(String word : words) {
            for (Character ch : word.toCharArray()) {
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new HashSet<>());
                }
            }
        }
        // construct the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            int j = 0;
            while (j < len) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    graph.get(ch1).add(ch2);
                    break;
                }
                j++;
            }
        }
        return graph;
    }
}


311. Sparse Matrix Multiplication
https://leetcode.com/problems/sparse-matrix-multiplication/ 

886. Possible Bipartition
https://leetcode.com/problems/possible-bipartition/ 

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }
}


112. Path Sum
https://leetcode.com/problems/path-sum/ 

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // dfs save the whole path sum from root to leaf, check it in leaf node
        if (root == null) {
            return false;
        }
        boolean[] result = new boolean[] {false};
        checkHelper(root, sum, result);
        return result[0];
    }
    
    private void checkHelper(TreeNode root, int sum, boolean[] result) {
        // base case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                result[0] = true;
            }
            return;
        }
        sum -= root.val;
        checkHelper(root.left, sum, result);
        checkHelper(root.right, sum, result);   
    }
}


113. Path Sum II
https://leetcode.com/problems/path-sum-ii/ 

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // carry an List of list as path, do dfs go to the left and right
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, cur, result);
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        // base case
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                cur.add(root.val);
                result.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        // for left and right
        cur.add(root.val);
        helper(root.left, sum - root.val, cur, result);
        helper(root.right, sum - root.val, cur, result);
        cur.remove(cur.size() - 1);
    }
}


124. Binary Tree Maximum Path Sum
class Solution{
	public int maxPathSum(TreeNode root){
		// corner case
		if(root == null){
			return new IllegalArgumentException();
}
}
}	
437. Path Sum III
https://leetcode.com/problems/path-sum-iii/         127 / 128 testcases passed

class Solution {
    public int pathSum(TreeNode root, int sum) {
        // 记录每一条路径的prefix sum, 用map的思路去找之前是否存在过一段路径满足要求
        if (root == null) {
            return 0;
        }
        // key: each prefix sum - value: occurence number of this prefix sum
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return helper(root, sum, 0, prefixSum);
    }
    
    // 返回值的物理意义代表以root为root的子树的所有满足要求的数量
    private int helper(TreeNode root, int sum, int prevSum, Map<Integer, Integer> prefixSum) {
        // base case 
        if (root == null) {
            return 0;
        }
        // 计算进入当前root的prefix sum
        prevSum += root.val;
        // 记录当前root的子树总共满足要求的个数
        int curSumNum = 0;
        // 记录满足要求的答案
        if (prefixSum.containsKey(prevSum - sum)) {
            curSumNum += prefixSum.get(prevSum - sum);
        }
        // 把当前prefixsum加上并recursion到左右子树
        prefixSum.put(prevSum, prefixSum.getOrDefault(prevSum, 0) + 1);
        curSumNum += helper(root.left, sum, prevSum, prefixSum);
        curSumNum += helper(root.right, sum, prevSum, prefixSum);
        prefixSum.put(prevSum, prefixSum.get(prevSum) - 1);
        return curSumNum;
    }
}


666. Path Sum IV
https://leetcode.com/problems/path-sum-iv/

719. Find K-th Smallest Pair Distance
https://leetcode.com/problems/find-k-th-smallest-pair-distance/ 

2187. Minimum Time to Complete Trips
https://leetcode.com/problems/minimum-time-to-complete-trips/ 

1927. Sum Game
https://leetcode.com/problems/sum-game/

class Solution {
    public boolean sumGame(String num) {
        char[] ch = num.toCharArray();
        int n = ch.length, half = n / 2;
        int lsum = 0, rsum = 0, lcount = 0, rcount = 0; //前一半数字和, 后一半数字和, 前半部分'?', 后半部分'?'
        
        //统计前、后一半的数字和和问号数
        for (int i = 0; i < half; i++) {
            if (ch[i] == '?')
                lcount++;
            else
                lsum += (int)(ch[i] - '0');
        }
        for (int i = half; i < n; i++) {
            if (ch[i] == '?')
                rcount++;
            else
                rsum += (int)(ch[i] - '0');
        }

        //计算差分
        int detSum = lsum - rsum, detCount = lcount - rcount; //前后段数字的差值, 问号的差值
        
        if (detCount == 0) //前后问号数相同, 左侧和同Bob处, 右侧同Alice处
            return detSum != 0;
        
        if ((detSum > 0 && detCount > 0) || (detSum < 0 && detCount < 0)) //数值和问号同号, 能否不可能
            return true;
        
        detSum = Math.abs(detSum); //此时数字和的差值是绝对数的差值, 并存为为绝对数的值
        detCount = Math.abs(detCount);
        
        if (detSum > detCount / 2 * 9 || detSum < (detCount + 1) / 2 * 9) //在绝对差大时, Bob无法进行再分, Alice无法填满
            return true;

        return false; //其他情况, 可以Count为偶数且detSum==detCount/2*9
    }
}


1944. Number of Visible People in a Queue
https://leetcode.com/problems/number-of-visible-people-in-a-queue/ 
群友刚面过

P1：
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/
class Solution {
    public List<String> generateParenthesis(int n) {
        // for each level, add left or right
        List<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, result);
        return result;
    }
    
    // left, right means how many remaining for left and right parentheses
    private void helper(int left, int right, StringBuilder sb, List<String> result) {
        // base case: left and right all done
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append('(');
            helper(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            helper(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/ 

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // control four variable left, right, up and down, for loop to print
        // if M != N, need to deal with corner case
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = cols - 1;
        int down = rows - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return result;
        }
        // only have one col
        if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
        } else {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
        }
        return result;
    }
}



128. Longest Consecutive Sequence
https://leetcode.com/problems/longest-consecutive-sequence/ 

class Solution {
    public int longestConsecutive(int[] nums) {
        // build a set to save all elements, iterative set to find the element without element - 1 in set
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int globalMax = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 0;
                while (set.contains(cur)) {
                    count++;
                    cur = cur + 1;
                }
                globalMax = Math.max(globalMax, count);
            }
        }
        return globalMax;
    }
}


213. Reconstruct Binary Tree With Preorder And Inorder
https://app.laicode.io/app/problem/213 
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/ 

public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    // Write your solution here
    Map<Integer, Integer> inIndex = indexMap(inOrder);
    return helper(inIndex, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
  }

  private Map<Integer, Integer> indexMap(int[] in){
    Map<Integer, Integer> inIndex = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      inIndex.put(in[i], i);
    }
    return inIndex;
  }

  private TreeNode helper(Map<Integer, Integer> indexMap, int[] pre, int inLeft, int inRight, int preLeft, int preRight){
    if(inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(pre[preLeft]);
    int inMid = indexMap.get(root.key);
    root.left = helper(indexMap, pre, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
    root.right = helper(indexMap, pre, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
    return root;
  }
}


263. Ugly Number 
https://leetcode.com/problems/ugly-number/ 

public boolean isUgly(int num) {
    if (num <= 0) {return false;}
    if (num == 1) {return true;}
    if (num % 2 == 0) {
        return isUgly(num/2);
    }
    if (num % 3 == 0) {
        return isUgly(num/3);
    }
    if (num % 5 == 0) {
        return isUgly(num/5);
    }
    return false;
}

692. Top K Frequent Words
https://leetcode.com/problems/top-k-frequent-words/

class Solution {
  public List<String> topKFrequent(String[] combo, int k) {
    Map<String, Integer> freqMap = new HashMap<>();

    for (String i : combo) {
      freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() != e2.getValue()) {
          return e1.getValue().compareTo(e2.getValue());
        }
        return e2.getKey().compareTo(e1.getKey());
      }
    });

    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
        minHeap.offer(entry);
        if (minHeap.size() > k) {
            minHeap.poll();
        }

    }

    List<String> result = new ArrayList<>();
while (!minHeap.isEmpty()) {
        result.add(minHeap.poll().getKey());
    }
    Collections.reverse(result);
    return result;

  }
}



785. Is Graph Bipartite?
https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        int[] color = new int[graph.length];
        
        // for (int i = 0; i < graph.length; i++) {
        //     if (color[i] == 0 && !checkIfMeetCondition(graph, color, i, 1)) {
        //         return false;
        //     }
        // }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0 && !checkIfMeetConditionBFS(graph, color, i)) {
                return false;
            }
        }
        return true;
        
    }
    
    private boolean checkIfMeetConditionBFS(int[][] graph, int[] color, int cur) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(cur);
        color[cur] = 1;
        
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            int curNodeColor = color[curNode];
            
            for (int next : graph[curNode]) {
                if (color[curNode] == color[next]) {
                    return false;
                }
                
                if (color[next] == 0) {
                    color[next] =  -curNodeColor;
                    queue.offer(next);
                   
                }
            }
        }
        return true;
    }
    
    private boolean checkIfMeetCondition(int[][] graph, int[] color, int cur, int curColor) {
        if (color[cur] != 0) {
            return color[cur] == curColor;
        }
        
        color[cur] = curColor;
        
        for (int next : graph[cur]) {
            if (!checkIfMeetCondition(graph, color, next, -curColor)) {
                return false;
            }
        }
        return true;
    }
}





1530. Number of Good Leaf Nodes Pairs(备注：又几个面国内组面到)
https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/ 

Hard：1944. Number of Visible People in a Queue
https://leetcode.com/problems/number-of-visible-people-in-a-queue/

735. Asteroid Collision
https://leetcode.com/problems/asteroid-collision/ 

class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty() || a[i] > 0) {
                stack.push(a[i]);
                continue;
            }
            
            while (true) {
                int prev = stack.peek();
                if (prev < 0) {
                    stack.push(a[i]);
                    break;
                }
                if (prev == -a[i]) {
                    stack.pop();
                    break;
                }
                if (prev > -a[i]) {
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(a[i]);
                    break;
                }
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}

 
1047. Remove All Adjacent Duplicates In String 
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/ 

class Solution {
    public String removeDuplicates(String S) {
        // stack to peek and move
        if (S == null || S.length() == 0) {
            return null;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.offerFirst(S.charAt(i));
            } else if (stack.peekFirst() == S.charAt(i)) {
                stack.pollFirst();
            } else {
                stack.offerFirst(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}


787. Cheapest Flights Within K Stops(ecommerce组intern面的787 要bfs+bellman ford)
https://leetcode.com/problems/cheapest-flights-within-k-stops/    




P2: 
1249. Minimum Remove to Make Valid Parentheses
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

884. Uncommon Words from Two Sentences
https://leetcode.com/problems/uncommon-words-from-two-sentences/ 

229. Majority Element II
https://leetcode.com/problems/majority-element-ii/ 

475. Heaters
https://leetcode.com/problems/heaters/ 

387. First Unique Character in a String
https://leetcode.com/problems/first-unique-character-in-a-string/ 

588. Design In-Memory File System
https://leetcode.com/problems/design-in-memory-file-system/ 

772. Basic Calculator III
https://leetcode.com/problems/basic-calculator-iii/ 

173. Compress String
https://app.laicode.io/app/problem/173 

518. Coin Change II 
https://leetcode.com/problems/coin-change-ii/ 

317. Shortest Distance from All Buildings
https://leetcode.com/problems/shortest-distance-from-all-buildings/

424. Longest Repeating Character Replacement
https://leetcode.com/problems/longest-repeating-character-replacement/ 

70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/ 
