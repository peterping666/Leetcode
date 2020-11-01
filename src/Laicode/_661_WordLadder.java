package Laicode;

import java.util.*;

public class _661_WordLadder {
    public class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if(!wordSet.contains(beginWord) && !wordSet.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            Map<String, Integer> visited = new HashMap<>();
            visited.put(beginWord, 1);
            while(!queue.isEmpty()) {
                String curWord = queue.poll();
                char[] curChars = curWord.toCharArray();
                for(int i = 0; i < curChars.length; i++) {
                    char c = curChars[i];
                    for(char l = 'a'; l <= 'z'; l++) {
                        if(c == l) {
                            continue;
                        }
                        curChars[i] = l;
                        String newWord = new String(curChars);
                        if(endWord.equals(newWord)) {
                            return visited.get(curWord) + 1;
                        }
                        if(wordSet.contains(newWord) && !visited.containsKey(newWord)) {
                            queue.offer(newWord);
                            visited.put(newWord, visited.get(curWord) + 1);
                        }
                    }
                    curChars[i] = c;
                }
            }
            return 0;
        }
    }

}
