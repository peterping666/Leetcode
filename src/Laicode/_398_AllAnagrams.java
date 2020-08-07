package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _398_AllAnagrams {
    public class Solution {
        public List<Integer> allAnagrams(String sh, String lo) {
            List<Integer> indices = new ArrayList<>();
            int[] counts = new int[26];
            int n = sh.length();
            for(int i = 0; i < n; i++) {
                counts[sh.charAt(i) - 'a']++;
            }
            int count = n;
            for(int i = 0, j = 0; i < lo.length(); i++) {
                if(counts[lo.charAt(i) - 'a']-- > 0) {
                    count--;
                }
                if(i - j + 1 > n && ++counts[lo.charAt(j++) - 'a'] > 0) {
                    count++;
                }
                if(count == 0) {
                    indices.add(j);
                }
            }
            return indices;
        }
    }

}
