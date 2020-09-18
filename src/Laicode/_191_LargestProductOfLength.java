package Laicode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _191_LargestProductOfLength {
    public class Solution {
        public int largestProduct(String[] dict) {
            Map<String, Integer> bitMasks = getBitMasks(dict);
            Arrays.sort(dict, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    if(a.length() == b.length()) {
                        return 0;
                    }
                    return a.length() < b.length() ? -1 : 1;
                }
            });
            int largest = 0;
            for(int i = 1; i < dict.length; i++) {
                for(int j = 0; j < i; j++) {
                    int prod = dict[i].length() * dict[j].length();
                    if(prod <= largest) {
                        continue;
                    }
                    int iMask = bitMasks.get(dict[i]);
                    int jMask = bitMasks.get(dict[j]);
                    if((iMask & jMask) == 0) {
                        largest = prod;
                    }
                }
            }
            return largest;
        }

        private Map<String, Integer> getBitMasks(String[] dict) {
            Map<String, Integer> map = new HashMap<>();
            for(String str : dict) {
                int bitMask = 0;
                for(int i = 0; i < str.length(); i++) {
                    bitMask |= 1 << str.charAt(i) - 'a';
                }
                map.put(str, bitMask);
            }
            return map;
        }
    }

}
