import java.util.*;

public class _472_ConcatenatedWords {
    /**
     * Time O(n^3 * l)
     * Space O(n)
     */
    class Solution1 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for(String word : words) {
                set.add(word);
            }
            for(String word : words) {
                if(valid(word, set)) {
                    res.add(word);
                }
            }
            return res;
        }

        private boolean valid(String word, Set<String> set) {
            int n = word.length();
            if(n == 0) {
                return false;
            }
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                    if(j == 0 && i == n){
                        continue;
                    }
                    if(dp[j] && set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

    /**
     * Time O(nlogn + nl)
     */
    class Solution2 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<>();
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
            Trie trie = new Trie();
            trie.add(words[0]);
            for(int i = 1; i < words.length; i++) {
                String word = words[i];
                if(trie.search(word, 0, new boolean[word.length()])) {
                    res.add(word);
                }
                trie.add(word);
            }
            return res;
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

    class Solution3 {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> res = new ArrayList<>();
            Set<String> set = new HashSet<>();
            Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
            set.add(words[0]);
            for(int i = 1; i < words.length; i++) {
                String word = words[i];
                if(valid(word, set)) {
                    res.add(word);
                }
                set.add(word);
            }
            return res;
        }

        private boolean valid(String word, Set<String> set) {
            int n = word.length();
            if(n == 0) {
                return false;
            }
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            for(int i = 1; i <= n; i++) {
                for(int j = i-1; j >= 0; j--) {
                    if(dp[j] && set.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
