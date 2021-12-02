public class _1395_CountNumberofTeams {

    /**
     * Time O(n^2)
     * Space O(1)
     */
    class Solution1 {
        public int numTeams(int[] rating) {
            int n = rating.length;
            int res = 0;
            for(int i = 1; i < n; i++) {
                int leftSmall = 0, leftLarge = 0;
                for(int j = 0; j < i; j++) {
                    if(rating[j] < rating[i]) {
                        leftSmall++;
                    } else {
                        leftLarge++;
                    }
                }

                int rightSmall = 0, rightLarge = 0;
                for(int j = i+1; j < n; j++) {
                    if(rating[j] < rating[i]) {
                        rightSmall++;
                    } else {
                        rightLarge++;
                    }
                }
                res += leftSmall * rightLarge + leftLarge * rightSmall;
            }
            return res;
        }
    }

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution2 {
        public int numTeams(int[] rating) {
            int n = rating.length;
            int res = 0;
            int[] inc = new int[n];
            int[] dec = new int[n];
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    if(rating[j] < rating[i]) {
                        inc[i]++;
                        res += inc[j];
                    } else {
                        dec[i]++;
                        res += dec[j];
                    }
                }
            }
            return res;
        }
    }
}
