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
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return list;
        }
        int[] freq = new int[26];
        for(int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int count = p.length();
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(i - j == p.length() && freq[s.charAt(j++) - 'a']++ >= 0) {
                count++;
            }
            if(--freq[s.charAt(i) - 'a'] >= 0) {
                count--;
            }
            if(count == 0) {
                list.add(j);
            }

        }
        return list;
    }
}
