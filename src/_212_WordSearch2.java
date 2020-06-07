import java.util.ArrayList;
import java.util.List;

public class _212_WordSearch2 {
    /**
     * Time O(mn4*3^(L-1))    // L is the maximum length of words
     * space O(n)
     */
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        int index = c - 'a';
        if(c == '#' || node.children[index] == null) {
            return;
        }
        node = node.children[index];
        if(node.isWord) {
            res.add(node.word);
            node.isWord = false;
            node.word = "";
        }
        board[i][j] = '#';
        dfs(board, i+1, j, node, res);
        dfs(board, i-1, j, node, res);
        dfs(board, i, j+1, node, res);
        dfs(board, i, j-1, node, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
            cur.word = word;
        }
        return root;
    }
}
