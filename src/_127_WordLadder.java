import java.util.*;

public class _127_WordLadder {
    /**
     * Time O(m * 26)  m: beginWod.length
     * Space O(n) n: wordList.size()
     * @return
     */
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> words = new HashSet<>(wordList);
            if(!words.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            Map<String, Integer> visited = new HashMap<>();
            visited.put(beginWord, 1);

            while(!queue.isEmpty()) {
                String cur = queue.poll();
                char[] curChars = cur.toCharArray();
                for(int i = 0; i < curChars.length; i++) {
                    char c = curChars[i];
                    for(char l = 'a'; l <= 'z'; l++) {
                        curChars[i] = l;
                        String newWord = new String(curChars);

                        if(newWord.equals(endWord)) {
                            return visited.get(cur) + 1;
                        }

                        if(words.contains(newWord) && !visited.containsKey(newWord)) {
                            visited.put(newWord, visited.get(cur) + 1);
                            queue.offer(newWord);
                        }
                    }
                    curChars[i] = c;
                }
            }
            return 0;
        }
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
