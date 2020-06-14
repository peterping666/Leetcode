public class _467_UniqueSubstringsinWraparoundString {
    /**
     * Time O(n)
     * Space O(26)
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curCount = 0;
        for(int i = 0; i < p.length(); i++) {
            if(i != 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) + 25 == p.charAt(i - 1))) {
                curCount++;
            } else {
                curCount = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(curCount, count[p.charAt(i) - 'a']);
        }
        int total = 0;
        for(int num : count) {
            total += num;
        }
        return total;
    }
}
