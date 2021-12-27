import java.util.*;

public class _433_MinimumGeneticMutation {

    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            char[] charBank = {'A','C','G','T'};
            Set<String> set = new HashSet(Arrays.asList(bank));
            Map<String, Integer> map = new HashMap<>();
            Queue<String> queue = new ArrayDeque<>();
            map.put(start, 0);
            queue.offer(start);
            while(!queue.isEmpty()) {
                String cur = queue.poll();
                if(cur.equals(end)) {
                    return map.get(cur);
                }
                char[] arr = cur.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                    char ch = arr[i];
                    for(char c : charBank) {
                        arr[i] = c;
                        String next = new String(arr);
                        if(set.contains(next) && !map.containsKey(next)) {
                            map.put(next, map.get(cur) + 1);
                            queue.offer(next);
                        }
                    }
                    arr[i] = ch;
                }
            }
            return -1;
        }
    }
}
