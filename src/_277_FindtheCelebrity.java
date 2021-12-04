public class _277_FindtheCelebrity {
    /**
     * Time O(n)
     * Space O(1)
     */
    public class Solution{
        public int findCelebrity(int n) {
            int res = 0;
            for(int i = 1; i < n; i++) {
                if(knows(res, i)) {
                    res = i;
                }
            }
            for(int i = 0; i < n; i++) {
                if(res == i) {
                    continue;
                }
                if(!knows(i, res) || knows(res, i)) {
                    return -1;
                }
            }
            return res;
        }
    }

    boolean knows(int a, int b){return true;}
}
