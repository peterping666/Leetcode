public class _28_ImplementstrStr {
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
    /**
     * Time O((N-L)L)
     * Space O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }
            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if(n == 0) return 0;
        for(int i = 0; i < m - n + 1; i++) {
            int cur = i;
            while(cur - i < n && haystack.charAt(cur) == needle.charAt(cur - i)) {
                cur++;
            }
            if(cur - i == n) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Time O(n)
     * Space O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();

        if (L > n) return -1;

        long modulus = (long)Math.pow(2, 31);

        long curHash = 0;
        long targetHash = 0;

        for (int i = 0; i < L; ++i) {
            curHash = (curHash * 26 + haystack.charAt(i) - 'a') % modulus;
            targetHash = (targetHash * 26 + needle.charAt(i) - 'a') % modulus;
        }

        if (curHash == targetHash) return 0;

        long power = 1;
        for (int i = 0; i < L; ++i) power = (power * 26) % modulus;

        for (int i = 1; i < n - L + 1; i++) {
            curHash = (curHash * 26 - (haystack.charAt(i - 1) - 'a') * power
                    + (haystack.charAt(i + L - 1) - 'a')) % modulus;
            if (curHash == targetHash) return i;
        }
        return -1;
    }
    /**
     * Time O(N)
     * Space O(1)
     * @param idx
     * @param s
     * @return
     */
    // function to convert character to integer
    public int charToInt(int idx, String s) {
        return (int)s.charAt(idx) - (int)'a';
    }

    public int strStr3(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }
}
