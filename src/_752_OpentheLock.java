import java.util.*;

public class _752_OpentheLock {
    class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> q = new LinkedList<>();
            HashMap<String, Integer> seen = new HashMap<>();
            HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
            if(deadSet.contains("0000")) {
                return -1;
            }
            q.offer("0000");
            seen.put("0000", 0);
            while(!q.isEmpty()) {
                String cur = q.poll();
                if(cur.equals(target)) {
                    return seen.get(cur);
                }
                for(int i = 0; i < 4; i++) {
                    char[] curCharArr = cur.toCharArray();
                    char move1 = curCharArr[i] == '9' ? '0' : (char)(curCharArr[i] + 1);
                    char move2 = curCharArr[i] == '0' ? '9' : (char)(curCharArr[i] - 1);
                    curCharArr[i] = move1;
                    String str1 = String.valueOf(curCharArr);
                    curCharArr[i] = move2;
                    String str2 = String.valueOf(curCharArr);
                    if(!seen.containsKey(str1) && !deadSet.contains(str1)) {
                        seen.put(str1, seen.get(cur) + 1);
                        q.offer(str1);
                    }
                    if(!seen.containsKey(str2) && !deadSet.contains(str2)) {
                        seen.put(str2, seen.get(cur) + 1);
                        q.offer(str2);
                    }
                }
            }
            return -1;
        }
    }
}
