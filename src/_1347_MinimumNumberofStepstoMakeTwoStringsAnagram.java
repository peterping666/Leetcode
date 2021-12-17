public class _1347_MinimumNumberofStepstoMakeTwoStringsAnagram {
    class Solution {
        public int minSteps(String s, String t) {
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            int res = 0;
            for(int num : count) {
                if(num > 0) {
                    res += num;
                }
            }
            return res;
        }
    }
}
