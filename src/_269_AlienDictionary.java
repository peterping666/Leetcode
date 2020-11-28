import java.util.*;

public class _269_AlienDictionary {
    class Solution {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            int[] indegree = new int[26];
            buildGraph(graph, words, indegree);
            return findOrder(graph, indegree);
        }

        private void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree) {
            for(String word : words) {
                for(int i = 0; i < word.length(); i++) {
                    graph.putIfAbsent(word.charAt(i), new HashSet<>());
                }
            }
            for(int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                if(w1.length() > w2.length() && w1.startsWith(w2)) {
                    graph.clear();
                    return;
                }
                int minLen = Math.min(w1.length(), w2.length());
                for(int j = 0; j < minLen; j++) {
                    char first = w1.charAt(j);
                    char second = w2.charAt(j);
                    if(first != second) {
                        if(graph.get(first).add(second)) {
                            indegree[second - 'a']++;
                        }
                        break;
                    }
                }
            }
        }

        private String findOrder(Map<Character, Set<Character>> graph, int[] indegree) {
            StringBuilder sb = new StringBuilder();
            Queue<Character> queue = new ArrayDeque<>();
            for(char c : graph.keySet()) {
                if(indegree[c - 'a'] == 0) {
                    queue.offer(c);
                }
            }
            System.out.println(graph);
            while(!queue.isEmpty()) {
                char c = queue.poll();
                sb.append(c);
                for(char next : graph.get(c)) {
                    if(--indegree[next - 'a'] == 0) {
                        queue.offer(next);
                    }
                }
            }
            return sb.length() == graph.size() ? sb.toString() : "";
        }

    }
}
