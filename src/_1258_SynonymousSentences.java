import java.util.*;

public class _1258_SynonymousSentences {
    class Solution {
        public List<String> generateSentences(List<List<String>> synonyms, String text) {
            Map<String, List<String>> graph = new HashMap<>();
            for(List<String> synonym : synonyms) {
                String w1 = synonym.get(0);
                String w2 = synonym.get(1);
                addConnection(graph, w1, w2);
                addConnection(graph, w2, w1);
            }
            Set<String> set = new TreeSet<>();
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(text);
            while(!queue.isEmpty()) {
                String cur = queue.poll();
                set.add(cur);
                String[] words = cur.split("\\s");
                for(int i = 0; i < words.length; i++) {
                    if(graph.containsKey(words[i])) {
                        for(String word : graph.get(words[i])) {
                            words[i] = word;
                            String newStr = String.join(" ", words);
                            if(!set.contains(newStr)) {
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private void addConnection(Map<String, List<String>> graph, String w1, String w2) {
            graph.putIfAbsent(w1, new ArrayList<>());
            graph.get(w1).add(w2);
        }
    }
}
