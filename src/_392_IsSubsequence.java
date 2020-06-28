import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _392_IsSubsequence {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft++;
            }
            pRight++;
        }
        return pLeft == leftBound;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        if(s.length() > t.length()) return false;
        int idx = 0;
        for(int i = 0; i < t.length() && idx < s.length(); i++) {
            if(s.charAt(idx) == t.charAt(i)) {
                idx++;
            }
        }
        return idx == s.length();
    }

    //Follow up:
    //If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B,
    // and you want to check one by one to see if T has its subsequence.
    // In this scenario, how would you change your code?

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence3(String s, String t) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            if(!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new ArrayList<>());
            }
            map.get(t.charAt(i)).add(i);
        }
        int curIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) return false;
            boolean found = false;
            for(int idx : map.get(c)) {
                if(idx > curIdx) {
                    curIdx = idx;
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }
}
