import java.util.*;

public class _737_SentenceSimilarityII {
    class Solution {
        public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
            if(words1.length != words2.length) {
                return false;
            }
            Map<String, Set<String>> graph = new HashMap<>();
            for(List<String> pair : pairs) {
                graph.putIfAbsent(pair.get(0), new HashSet<>());
                graph.putIfAbsent(pair.get(1), new HashSet<>());
                graph.get(pair.get(0)).add(pair.get(1));
                graph.get(pair.get(1)).add(pair.get(0));
            }
            for(int i = 0; i < words1.length; i++) {
                if(words1[i].equals(words2[i])) {
                    continue;
                }
                if(!graph.containsKey(words1[i])) {
                    return false;
                }
                if (!dfs(graph, words1[i], words2[i], new HashSet<>())) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(Map<String, Set<String>> graph, String word, String target, Set<String> visited) {
            if(graph.get(word).contains(target)) {
                return true;
            }
            if(visited.add(word)) {
                for(String next : graph.get(word)) {
                    if(dfs(graph, next, target, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
