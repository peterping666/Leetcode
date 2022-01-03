public class _28_ImplementstrStr {
    /**
     * Time O(n)
     */
    class Solution {
        public int strStr(String haystack, String needle) {
            int n = needle.length();
            if(haystack.length() < n) {
                return -1;
            }
            if(n == 0) {
                return 0;
            }

            int prime = 31;
            int largePrime = 101;
            int seed = 1;
            int hash = haystack.charAt(0) % largePrime;
            int targetHash = needle.charAt(0) % largePrime;
            for(int i = 1; i < n; i++) {
                seed = hashing(seed, 0, prime, largePrime);
                hash = hashing(hash, haystack.charAt(i), prime, largePrime);
                targetHash = hashing(targetHash, needle.charAt(i), prime, largePrime);
            }

            if(hash == targetHash && equals(haystack, needle, 0)) {
                return 0;
            }

            for(int i = 1; i <= haystack.length() - n; i++) {
                hash = nonNegtive(hash - seed * haystack.charAt(i - 1) % largePrime, largePrime);
                hash = hashing(hash, haystack.charAt(i + n - 1), prime, largePrime);
                if(hash == targetHash && equals(haystack, needle, i)) {
                    return i;
                }
            }
            return -1;
        }

        private int hashing(int hash, int addition, int prime, int largePrime) {
            return (hash * prime % largePrime + addition) % largePrime;
        }

        private int nonNegtive(int hash, int largePrime) {
            if(hash < 0) {
                hash += largePrime;
            }
            return hash;
        }

        private boolean equals(String large, String small, int start) {
            for(int i = 0; i < small.length(); i++) {
                if(large.charAt(i + start) != small.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
