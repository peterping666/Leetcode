public class _211_AddandSearchWordDatastructuredesign {

    class WordDictionary {

        TrieNode root;

        class TrieNode {
            TrieNode[] children;
            boolean isWord;

            public TrieNode() {
                children = new TrieNode[26];
                isWord = false;
            }
        }

        public WordDictionary() {
            root = new TrieNode();
        }

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
}

