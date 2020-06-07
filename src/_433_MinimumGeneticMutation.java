import java.util.*;

public class _433_MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] charBank = {'A','C','G','T'};
        HashSet<String> set = new HashSet(Arrays.asList(bank));
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put(start, 0);
        queue.offer(start);
        while(!queue.isEmpty()) {
            String curStr = queue.poll();
            for(int i = 0; i < curStr.length(); i++) {
                char[] curChars = curStr.toCharArray();
                for(char c : charBank) {
                    curChars[i] = c;
                    String newStr = String.valueOf(curChars);
                    if(set.contains(newStr) && newStr.equals(end)) {
                        return map.get(curStr) + 1;
                    }
                    if(!map.containsKey(newStr) && set.contains(newStr)) {
                        map.put(newStr, map.get(curStr) + 1);
                        queue.offer(newStr);
                    }
                }
            }
        }
        return -1;
    }
}
