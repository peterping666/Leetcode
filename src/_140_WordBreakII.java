import java.util.*;

public class _140_WordBreakII {

    /**
     * Time O(n^3)
     */
    class Solution1 {

        public List<String> wordBreak(String s, List<String> wordDict) {
            return helper(s, new HashSet<>(wordDict), new HashMap<String,List<String>>());
        }

        private List<String> helper(String s, Set<String> wordDict, Map<String,List<String>> map) {
            List<String> res = new ArrayList<String>();
            if(s == null || s.length() == 0) {
                return res;
            }
            if(map.containsKey(s)) {
                return map.get(s);
            }
            if(wordDict.contains(s)) {
                res.add(s);
            }
            for(int i = 1 ; i < s.length() ; i++) {
                String t = s.substring(0, i);
                if(wordDict.contains(t)) {
                    List<String> list = helper(s.substring(i) , wordDict, map);
                    for(int j = 0 ; j < list.size() ; j++) {
                        res.add(t + " " + list.get(j));
                    }
                }
            }
            map.put(s , res);
            return res;
        }
    }

    /**
     * Time O(n)
     */
    class Solution2 {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Trie trie = new Trie();
            for(String word : wordDict) {
                trie.add(word);
            }
            List<String> res = new ArrayList<>();
            trie.search(s, 0, new boolean[s.length()], res, new ArrayList<>());
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

            boolean search(String s, int start, boolean[] memo, List<String> res, List<String> list) {
                if(start == s.length()) {
                    res.add(String.join(" ", list));
                    return true;
                }
                if(memo[start]) {
                    return false;
                }
                Node cur = root;
                boolean valid = false;
                for(int i = start; i < s.length(); i++) {
                    int index = s.charAt(i) - 'a';
                    if(cur.children[index] == null) {
                        break;
                    }
                    cur = cur.children[index];
                    if(cur.isWord) {
                        list.add(s.substring(start, i + 1));
                        if(search(s, i + 1, memo, res, list)) {
                            valid = true;
                        }
                        list.remove(list.size() - 1);
                    }
                }
                memo[start] = !valid;
                return valid;
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
