class _208_ImplementTriePrefixTree {

    class Trie {

        /** Initialize your data structure here. */
        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode(){
                children = new TrieNode[26];
                isWord = false;
            }
        }

        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];
            }
            return true;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
