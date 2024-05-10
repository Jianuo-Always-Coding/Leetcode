class Trie {

    // 定义node class
    public class TrieNode {
        TrieNode[] children;
        boolean isWord; // 是不是word

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }


    TrieNode root;
    // 初始化 constructor
    public Trie() {
        root = new TrieNode();
    }
    
    // 插入，往下找，有路径就往下没路径就新建，最后把isword更新为true
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }
    
    // 能查完到最后一个看看isword，没路径没查完直接为false
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            if (node.children[word.charAt(i) - 'a'] == null) return false;
            else {
                node = node.children[word.charAt(i) - 'a'];
            }
        }
        return node.isWord;
    }
    
    // 有没有路径，逻辑和search一样
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            if (node.children[prefix.charAt(i) - 'a'] == null) return false;
            else {
                node = node.children[prefix.charAt(i) - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
