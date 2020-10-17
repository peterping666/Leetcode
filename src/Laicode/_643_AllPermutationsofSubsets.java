package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _643_AllPermutationsofSubsets {
    public class Solution1 {
        public List<String> allPermutationsOfSubsets(String set) {
            List<String> result = new ArrayList<>();
            helper(result, set.toCharArray(), 0);
            return result;
        }

        private void helper(List<String> result, char[] array, int index) {
            result.add(new String(array, 0, index));

            for(int i = index; i < array.length; i++) {
                swap(array, index, i);
                helper(result, array, index + 1);
                swap(array, index, i);
            }
        }

        private void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public class Solution2 {
        public List<String> allPermutationsOfSubsets(String set) {
            List<String> result = new ArrayList<>();
            subsets(result, set, new StringBuilder(), 0);
            return result;
        }

        private void subsets(List<String> result, String set, StringBuilder path, int index) {
            if(index == set.length()) {
                char[] arr = new char[path.length()];
                for(int i = 0; i < path.length(); i++) {
                    arr[i] = path.charAt(i);
                }
                permutation(result, arr, 0);
                return;
            }
            // we select the char
            path.append(set.charAt(index));
            subsets(result, set, path, index + 1);
            // we don't
            path.deleteCharAt(path.length() - 1);
            subsets(result, set, path, index + 1);
        }

        private void permutation(List<String> result, char[] path, int index) {
            if(index == path.length) {
                result.add(new String(path));
                return;
            }
            for(int i = index; i < path.length; i++) {
                swap(path, index, i);
                permutation(result, path, index + 1);
                swap(path, index, i);
            }
        }

        private void swap(char[] arr, int left, int right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

}
