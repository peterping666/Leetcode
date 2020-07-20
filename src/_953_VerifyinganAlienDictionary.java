public class _953_VerifyinganAlienDictionary {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] index = new int[26];
            for(int i = 0; i < order.length(); i++) {
                index[order.charAt(i) - 'a'] = i;
            }
            for(int i = 0; i < words.length - 1; i++) {
                for(int j = 0; j < words[i].length(); j++) {
                    int idx1 = index[words[i].charAt(j) - 'a'];
                    if(j == words[i+1].length()) {
                        return false;
                    }
                    int idx2 = index[words[i+1].charAt(j) - 'a'];
                    if(idx1 > idx2) {
                        return false;
                    } else if(idx1 < idx2) {
                        break;
                    }
                }
            }
            return true;
        }
    }
}
