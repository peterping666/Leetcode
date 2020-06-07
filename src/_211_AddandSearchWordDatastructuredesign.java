public class _211_AddandSearchWordDatastructuredesign {

    class WordDictionary {

        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
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

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return find(0, word, root);
        }
        private boolean find(int start, String word, TrieNode cur) {
            for(int i = start; i < word.length(); i++) {
                if(word.charAt(i) == '.') {
                    for(int j = 0; j < 26; j++) {
                        if(cur.children[j] != null) {
                            if(find(i+1, word, cur.children[j])) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    int index = word.charAt(i) - 'a';
                    if(cur.children[index] == null) {
                        return false;
                    }
                    cur = cur.children[index];
                }
            }
            return cur.isWord;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}

