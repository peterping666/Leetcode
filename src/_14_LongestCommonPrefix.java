public class _14_LongestCommonPrefix {
    /**
     * Time O(n * l) l is the smallest length of words, n is # of words
     * Space O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String firstStr = strs[0];
        for(int i = 0; i < firstStr.length(); i++) {
            char letter = firstStr.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() - 1 < i || strs[j].charAt(i) != letter) {
                    return firstStr.substring(0,i);
                }
            }
        }
        return firstStr;
    }

    /**
     * Time O(n * l)
     * Space O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * This LCP query will be called frequently.
     * Time O(n * l)
     * Space O(n * l)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String str : strs) {
            trie.insert(str);
        }
        return trie.findLongestCommonPrefix();
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                    cur.childrenNum++;
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        public String findLongestCommonPrefix() {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            while(cur.childrenNum == 1 && !cur.isWord) {
                for(int i = 0; i < 26; i++) {
                    if(cur.children[i] != null) {
                        sb.append((char)(i + 'a'));
                        cur = cur.children[i];
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        int childrenNum;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            childrenNum = 0;
        }
    }
}


