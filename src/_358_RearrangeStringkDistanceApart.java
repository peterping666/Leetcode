import java.util.*;

public class _358_RearrangeStringkDistanceApart {
    /**
     * Time O(n)
     * Space O(n)
     * @param str
     * @param k
     * @return
     */
    public String rearrangeString1(String str, int k) {
        int n = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i = 0; i < n; i++){
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int candidatePos = findValidMax(count, valid, i);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = i + k;
            sb.append((char)('a' + candidatePos));
        }
        return sb.toString();
    }

    private int findValidMax(int[] count, int[] valid, int index){
        int max = 0;
        int candidatePos = -1;
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0 && count[i] > max && index >= valid[i]){
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }

    /**
     * Time O(nlogn)
     * Space O(n)
     * @param str
     * @param k
     * @return
     */
    public String rearrangeString2(String str, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> Integer.compare(b.getValue(), a.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);
            queue.offer(current);

            if (queue.size() < k) {
                continue;
            }
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }
        return sb.length() == str.length() ? sb.toString() : "";
    }
}
