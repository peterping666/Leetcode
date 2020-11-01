import java.util.*;

public class _126_WordLadderII {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            Map<String, List<String>> g = buildGraphWithBfs(beginWord, endWord, wordSet);
            List<List<String>> res = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            temp.add(beginWord);
            findShortestPathWithDfs(beginWord, endWord, temp, res, g);
            return res;
        }
        private Map<String, List<String>> buildGraphWithBfs(String beginWord, String endWord, Set<String> wordSet) {
            Map<String, List<String>> g = new HashMap<>();

            Deque<String> q = new ArrayDeque<>();
            q.offer(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            boolean isFound = false;
            while (!q.isEmpty() && !isFound) {
                int size = q.size();

                // still need to visited in the current level but not next level
                // in order to find all possible shortest path between levels
                Set<String> nextVisited = new HashSet<>();
                while (size-- > 0) {
                    String curWord = q.poll();

                    List<String> nextWords = getNextWords(curWord, wordSet);

                    for (String nextWord : nextWords) {
                        if (nextWord.equals(endWord)) isFound = true;

                        if (!visited.contains(nextWord)) {
                            g.computeIfAbsent(curWord, k -> new ArrayList<>()).add(nextWord);

                            if (!nextVisited.contains(nextWord)) {
                                q.offer(nextWord);
                                nextVisited.add(nextWord);
                            }
                        }
                    }
                }
                visited.addAll(nextVisited);
            }

            return g;
        }

        private List<String> getNextWords(String curWord, Set<String> wordSet) {
            List<String> nextWords = new ArrayList<>();

            for (int i = 0; i < curWord.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] chars = curWord.toCharArray();
                    chars[i] = c;
                    String nextWord = new String(chars);
                    if (wordSet.contains(nextWord)) nextWords.add(nextWord);
                }
            }

            return nextWords;
        }
        private void findShortestPathWithDfs(String curWord, String endWord, List<String> temp, List<List<String>> res,
                                             Map<String, List<String>> g) {
            if (curWord.equals(endWord)) {
                res.add(new ArrayList<>(temp));
                return;
            }

            if (g.containsKey(curWord)) {
                for (String nextWord : g.get(curWord)) {
                    temp.add(nextWord);
                    findShortestPathWithDfs(nextWord, endWord, temp, res, g);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
