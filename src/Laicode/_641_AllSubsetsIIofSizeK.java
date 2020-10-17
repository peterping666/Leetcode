package Laicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _641_AllSubsetsIIofSizeK {
    public class Solution1 {
        public List<String> subSetsIIOfSizeK(String set, int k) {
            char[] array = set.toCharArray();
            Arrays.sort(array);
            List<String> result = new ArrayList<>();
            helper(array, result, new StringBuilder(), k, 0);
            return result;
        }

        private void helper(char[] array, List<String> result, StringBuilder cur, int k, int index) {

            if(cur.length() == k) {
                result.add(cur.toString());
                return;
            }
            for(int i = index; i < array.length; i++) {
                if(i != index && array[i] == array[i - 1]) {
                    continue;
                }
                cur.append(array[i]);
                helper(array, result, cur, k, i + 1);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public class Solution2 {
        public List<String> subSetsIIOfSizeK(String set, int k) {
            char[] array = set.toCharArray();
            Arrays.sort(array);
            List<String> result = new ArrayList<>();
            helper(array, result, new StringBuilder(), k, 0);
            return result;
        }

        private void helper(char[] array, List<String> result, StringBuilder cur, int k, int index) {
            if(cur.length() == k) {
                result.add(cur.toString());
                return;
            }
            if(index == array.length) {
                return;
            }
            cur.append(array[index]);
            helper(array, result, cur, k, index + 1);
            while(index < array.length - 1 && array[index] == array[index + 1]) {
                index++;
            }
            cur.deleteCharAt(cur.length() - 1);
            helper(array, result, cur, k, index + 1);
        }
    }

}
