public class _277_FindtheCelebrity {
    /**
     * Time O(n)
     * Space O(1)
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }

    boolean knows(int a, int b){return true;}
}
