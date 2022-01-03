import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {
    /**
     * Time O(n^3 * l)
     * Space O(n)
     */
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            Set<String> set = new HashSet<>(wordDict);
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    if(dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    /**
     * Time O(n + kl)
     */
    class Solution2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            Trie trie = new Trie();
            for(String word : wordDict) {
                trie.add(word);
            }
            return trie.search(s, 0, new boolean[s.length()]);

        }


        class Trie {
            Node root;

            Trie() {
                root = new Node();
            }

            void add(String word) {
                Node cur = root;
                for(int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if(cur.children[index] == null) {
                        cur.children[index] = new Node();
                    }
                    cur = cur.children[index];
                }
                cur.isWord = true;
            }

            boolean search(String s, int start, boolean[] memo) {
                if(start == s.length()) {
                    return true;
                }
                if(memo[start]) {
                    return false;
                }
                Node cur = root;
                for(int i = start; i < s.length(); i++) {
                    int index = s.charAt(i) - 'a';
                    if(cur.children[index] == null) {
                        break;
                    }
                    cur = cur.children[index];
                    if(cur.isWord && search(s, i + 1, memo)) {
                        return true;
                    }
                }
                memo[start] = true;
                return false;
            }

            class Node {
                Node[] children;
                boolean isWord;

                Node() {
                    children = new Node[26];
                }
            }
        }
    }
}
