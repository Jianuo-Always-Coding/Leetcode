class Solution {

    static final int[][] DIRS = {{-1, 0},{1, 0},{0, -1},{0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        // corner case
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        Set<String> res = new HashSet<>(); // 存放结果，因为不会有重复，所以拿set去重
        TrieNode root = buildDict(words);
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                helper(board, i, j, root, sb, res, visited);
            }
        }
        return new ArrayList<>(res);
    }

    public TrieNode buildDict(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            // 从头开始插入路径
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode next = cur.children[word.charAt(i) - 'a'];
                // 没有这条路径
                if (next == null) {
                    next = new TrieNode();
                    cur.children[word.charAt(i) - 'a'] = next;
                }
                // 向下走
                cur = next;
            }
            // 找完把isWord标注为true
            cur.isWord = true;
        }
        return root;
    }

    public void helper(char[][] board, int x, int y, TrieNode root, StringBuilder sb, Set<String> res, boolean[][] visited) {
        // base case
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return ;
        }

        char c = board[x][y];
        // 没有这条路径
        if (root.children[c - 'a'] == null) {
            return;
        }
        sb.append(c); // 有路径，加入字母
        root = root.children[c - 'a']; // 向下走

        // 找到单词加入结果
        if (root.isWord) {
            res.add(sb.toString());
        }
        // 当前访问过这个点了
        visited[x][y] = true;

        // 向四个方向走
        for (int[] dir : DIRS) {
            int X = dir[0] + x;
            int Y = dir[1] + y;
            helper(board, X, Y, root, sb, res, visited);
        }
        // 恢复原来的sb和visited
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    
}

// 定义trie
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}