public class _161_OneEditDistance {
    /**
     * Time O(min(ls, lt))
     * Space O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int diff = Math.abs(m - n);
        if(diff > 1) return false;
        for(int i = 0; i < Math.min(m, n); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(diff == 0) return s.substring(i+1).equals(t.substring(i + 1));
                else if(m > n) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return diff == 1;
    }
}
