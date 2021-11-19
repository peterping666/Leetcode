import java.util.*;

public class _126_WordLadderII {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return ans;

            Queue<List<String>> queue = new LinkedList<>();   // each element in queue is a path
            queue.offer(Arrays.asList(beginWord));
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            boolean found = false;

            while (!queue.isEmpty()) {
                int sz = queue.size();
                while (sz-- > 0) {
                    List<String> currPath = queue.poll();
                    String lastWord = currPath.get(currPath.size()-1);
                    List<String> neighbors = getNeighbors(lastWord, wordSet);
                    for (String neigh : neighbors) {
                        List<String> newPath = new ArrayList<>(currPath);
                        newPath.add(neigh);
                        visited.add(neigh);
                        if (neigh.equals(endWord)) {
                            ans.add(newPath);
                            found = true;
                        } else {
                            queue.offer(newPath);
                        }
                    }
                }

                if(found) {
                    break;
                }

                for (String s : visited)   // remove used words from wordSet to avoid going back
                    wordSet.remove(s);
            }

            return ans;
        }

        private List<String> getNeighbors(String word, Set<String> wordSet) {
            List<String> neighbors = new LinkedList<>();
            for (int i = 0; i < word.length(); i++) {
                char[] ch = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String str = new String(ch);
                    if (wordSet.contains(str))  // only get valid neighbors
                        neighbors.add(str);
                }
            }
            return neighbors;
        }
    }
}
