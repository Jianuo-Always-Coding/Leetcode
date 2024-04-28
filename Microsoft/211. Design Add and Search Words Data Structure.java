class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchWord(word, root);
    }

    private boolean searchWord(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : node.children.values()) {
                    if (searchWord(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                }
                node = node.get(ch);
            }
        }
        return node.isEnd();
    }

    private static class TrieNode {
        private final Map<Character, TrieNode> children;
        private boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }

        public boolean containsKey(char ch) {
            return children.containsKey(ch);
        }

        public TrieNode get(char ch) {
            return children.get(ch);
        }

        public void put(char ch, TrieNode node) {
            children.put(ch, node);
        }


        public boolean isEnd() {
            return isEnd;
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */