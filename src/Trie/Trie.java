package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    class TrieNode {
        TrieNode[] children;
//        Map<Character, TrieNode> children; // All charactor
        boolean isWord;
        int numWords; // number of words in the subtree

        TrieNode() {
            children = new TrieNode[26]; // store charactor from 'a' to 'z'
        }
    }

    public Trie() {
        root = new TrieNode();
    }

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

    public TrieNode searchNode(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null) {
                return null;
            }
            cur = cur.children[pos];
        }
        if(cur.isWord) {
            return cur;
        }
        return null;
    }

    public boolean insert(String word) {
        TrieNode cur = root;
        if(search(word)) {
            return false;
        }
        for(int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
            cur.numWords++;
        }
        cur.isWord = true;
        return true;
    }

    public boolean delete(String word) {
        if(!search(word)) {
            return false;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos].numWords == 1) {
                cur.children[pos] = null;
                return true;
            }
            cur.children[pos].numWords--;
            cur = cur.children[pos];
        }
        cur.isWord = false;
        return true;
    }

    public List<String> findAllWithPrefix(String prefix) {
        TrieNode matchNode = searchNode(prefix);
        List<String> result = new ArrayList<>();
        if(matchNode == null) {
            return result;
        }
        dfsHelper(matchNode, new StringBuilder(prefix), result);
        return result;
    }

    private void dfsHelper(TrieNode current, StringBuilder curPath, List<String> result) {
        if(current == null) {
            return;
        }
        if(current.isWord) {
            result.add(curPath.toString());
        }
        for(int i = 0; i < current.children.length; i++) {
            char c = (char) (i + 'a');
            curPath.append(c);
            dfsHelper(current.children[i], curPath, result);
            curPath.deleteCharAt(curPath.length() - 1);
        }
    }

    public List<String> findAllMatchWildCard(String target) {
        List<String> result = new ArrayList<>();
        if(target == null || target.isEmpty()) {
            return result;
        }
        findAllMatchByDFS(root, target, 0, new StringBuilder(), result);
        return result;
    }

    private void findAllMatchByDFS(TrieNode cur, String target, int index, StringBuilder curPath, List<String> result) {
        if(index == target.length()) {
            if(cur.isWord) {
                result.add((curPath.toString()));
            }
            return;
        }
        if(target.charAt(index) == '?') {
            for(int i = 0; i < cur.children.length; i++) {
                if(cur.children[i] != null) {
                    curPath.append(i+'a');
                    findAllMatchByDFS(cur, target, index + 1, curPath, result);
                    curPath.deleteCharAt(curPath.length() - 1);
                }
            }
        } else if(cur.children[target.charAt(index) - 'a'] != null) {
            curPath.append(target.charAt(index));
            findAllMatchByDFS(cur, target, index + 1, curPath, result);
            curPath.deleteCharAt(curPath.length() - 1);
        }
    }
}
