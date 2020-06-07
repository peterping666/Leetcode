public class _38_CountandSay {
    /**
     * Time O(don't know yet)
     * Space O(n)
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        for(int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            int count = 1;
            for(int j = 0; j < cur.length(); j++) {
                if(j == cur.length() - 1) {
                    next.append(count).append(cur.charAt(j));
                } else if (cur.charAt(j) == cur.charAt(j + 1)) {
                    count++;
                } else {
                    next.append(count).append(cur.charAt(j));
                    count = 1;
                }
            }
            cur = next;
        }
        return cur.toString();
    }
}
