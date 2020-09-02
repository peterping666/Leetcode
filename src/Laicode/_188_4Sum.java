package Laicode;

import java.util.Arrays;

public class _188_4Sum {
    public class Solution {
        public boolean exist(int[] array, int target) {
            Arrays.sort(array);
            for(int i = 0; i < array.length; i++) {
                for(int j = i + 1; j < array.length; j++) {
                    int val = target - array[i] - array[j];
                    int left = j + 1;
                    int right = array.length - 1;
                    while(left < right) {
                        if(array[left] + array[right] == val) {
                            return true;
                        } else if(array[left] + array[right] < val) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return false;
        }
    }

}
