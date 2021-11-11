import java.util.*;

public class _358_RearrangeStringkDistanceApart {
    /**
     * Time: O(nlog26)
     * Space: O(n)
     */
    class Solution {
        public String rearrangeString(String s, int k) {
            if(k==0) return s;
            int[] freq = new int[26];
            StringBuilder ans = new StringBuilder();

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

            for(int i = 0; i < 26; i++) {
                if(freq[i] > 0) {
                    pq.add(new int[]{i, freq[i]});
                }
            }

            Queue<int[]> q = new LinkedList<>();

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                ans.append((char)(current[0] + 'a'));
                current[1]--;
                q.add(current);
                if (q.size() >= k) {
                    int[] front = q.poll();
                    if (front[1] > 0) pq.add(front);
                }
            }
            return ans.length() == s.length() ? ans.toString() : "";
        }
    }
}
