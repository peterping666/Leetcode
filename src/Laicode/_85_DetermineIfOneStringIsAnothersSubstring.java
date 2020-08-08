package Laicode;

public class _85_DetermineIfOneStringIsAnothersSubstring {
    public class Solution {
        public int strstr(String large, String small) {
            if(large.length() < small.length()) {
                return -1;
            }
            if(small.equals("")) {
                return 0;
            }
            int n = small.length();
            int largePrime = 101;
            int prime = 31;
            int seed = 1;
            int targetHash = small.charAt(0) % largePrime;
            int hash = large.charAt(0) % largePrime;
            for(int i = 1; i < n; i++) {
                seed = moduleHash(seed, 0, prime, largePrime);
                targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
                hash = moduleHash(hash, large.charAt(i), prime, largePrime);
            }

            if(hash == targetHash && equals(large, 0, small)) {
                return 0;
            }

            for(int i = 1; i <= large.length() - n; i++) {
                hash = nonNegtive(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
                hash = moduleHash(hash, large.charAt(i + n - 1), prime, largePrime);

                if(hash == targetHash && equals(large, i, small)) {
                    return i;
                }
            }
            return -1;
        }

        private boolean equals(String large, int start, String small) {
            for(int i = 0; i < small.length(); i++) {
                if(large.charAt(i + start) != small.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private int moduleHash(int hash, int addition, int prime, int largePrime) {
            return (hash * prime % largePrime + addition) % largePrime;
        }

        private int nonNegtive(int hash, int largePrime) {
            if(hash < 0) {
                hash += largePrime;
            }
            return hash;
        }
    }
}
