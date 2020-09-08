package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _644_CommonElementsInKSortedLists {
    public class Solution {
        public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
            List<Integer> common = input.get(0);
            for(int i = 1; i < input.size(); i++) {
                common = twoCommon(common, input.get(i));
            }
            return common;
        }

        private List<Integer> twoCommon(List<Integer> a, List<Integer> b) {
            int ai = 0;
            int bi = 0;
            List<Integer> common = new ArrayList<>();
            while(ai < a.size() && bi < b.size()) {
                if(a.get(ai) == b.get(bi)) {
                    common.add(a.get(ai));
                    ai++;
                    bi++;
                } else if(a.get(ai) <= b.get(bi)) {
                    ai++;
                } else {
                    bi++;
                }
            }
            return common;
        }
    }

}
