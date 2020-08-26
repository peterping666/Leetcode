import java.util.ArrayList;
import java.util.List;

public class _438_FindAllAnagramsinaString {
    /**
     * Time O(Ns + Np)
     * Space O(1)
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()) {
            return list;
        }
        if(s.length() == 0 || p.length() == 0) return list;
        int[] freq = new int[26];
        for(int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
            freq[s.charAt(i) - 'a']--;
        }
        int absSum = 0;
        for(int num : freq) {
            absSum += Math.abs(num);
        }
        if(absSum == 0) {
            list.add(0);
        }
        for(int i = 1; i < s.length() - p.length() + 1; i++) {
            int idx1 = s.charAt(i - 1) - 'a';
            int idx2 = s.charAt(i + p.length() - 1) - 'a';

            absSum -= Math.abs(freq[idx1]) + Math.abs(freq[idx2]);
            freq[idx1]++;
            freq[idx2]--;
            absSum += Math.abs(freq[idx1]) + Math.abs(freq[idx2]);

            if(absSum == 0) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Time O(Ns + Np)
     * Space O(1)
     * Assume s and p are not null
     * High level idea is using sliding window to solve this problem
     * @return
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int n = p.length();
            int[] count = new int[26];
            for(int i = 0; i < n; i++) {
                count[p.charAt(i) - 'a']++;
            }
            int counter = n;
            // the string between j and i is what we are checking if it's a anagram of p
            for(int i = 0, j = 0; i < s.length(); i++) {
                if(--count[s.charAt(i) - 'a'] >= 0) {
                    counter--;
                }
                if(i - j + 1 > n && ++count[s.charAt(j++) - 'a'] > 0) {
                    counter++;
                }
                if(counter == 0) {
                    res.add(j);
                }
            }
            return res;
        }
    }
}
