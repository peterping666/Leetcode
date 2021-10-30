public class _266_PalindromePermutation {
    class Solution {
        public boolean canPermutePalindrome(String s) {
            int[] arr = new int[26];
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) -  'a']++;
                if (arr[s.charAt(i) - 'a'] % 2 == 0)
                    count--;
                else
                    count++;
            }
            return count <= 1;
        }
    }
}
