import javafx.util.Pair;

import java.util.*;

public class _127_WordLadder {
    /**
     * Time O(m * 26 * n)
     * Space O(m * 26 * n)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        map.put(beginWord, 1);
        queue.offer(beginWord);
        while(!queue.isEmpty()) {
            String curWord = queue.poll();
            for(int i = 0; i < curWord.length(); i++) {
                char[] curWordChars = curWord.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    curWordChars[i] = ch;
                    String newWord = new String(curWordChars);
                    if (wordSet.contains(newWord) && newWord.equals(endWord)) return map.get(curWord) + 1;
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, map.get(curWord) + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Time O(m * 26 * n)
     * Space O(m * 26 * n)
     */
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
