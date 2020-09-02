package Laicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _186_3Sum {
    public class Solution {
        public List<List<Integer>> allTriples(int[] array, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(array);
            for(int i = 0; i < array.length; i++) {
                if(i > 0 && array[i] == array[i - 1]) {
                    continue;
                }
                int val = target - array[i];
                int left = i + 1;
                int right = array.length - 1;
                while(left < right) {
                    if(array[left] + array[right] == val) {
                        res.add(Arrays.asList(array[i], array[left], array[right]));
                        left++;
                        right--;
                        while(left < right && left > i + 1 && array[left] == array[left - 1]) {
                            left++;
                        }
                        while(left < right && right < array.length - 1 && array[right] == array[right + 1]) {
                            right--;
                        }
                    } else if(array[left] + array[right] < val) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }

}
