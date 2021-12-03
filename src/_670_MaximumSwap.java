import java.util.HashMap;
import java.util.Map;

public class _670_MaximumSwap {

    class Solution1 {
        public int maximumSwap(int num) {
            char[] arr = String.valueOf(num).toCharArray();
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 1; i < arr.length; i++) {
                map.put(arr[i], i);
            }
            for(int i = 0; i < arr.length; i++) {
                for(char j = '9'; j > arr[i]; j--) {
                    if(map.containsKey(j) && map.get(j) > i) {
                        swap(arr, i, map.get(j));
                        return Integer.valueOf(String.valueOf(arr));
                    }
                }
            }
            return num;
        }

        private void swap(char[] arr, int left, int right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }

    class Solution2 {
        public int maximumSwap(int num) {
            char[] digits = String.valueOf(num).toCharArray();
            int[] lastIndex = new int[10];
            for(int i = 0; i < digits.length; i++) {
                lastIndex[digits[i] - '0'] = i;
            }
            int max = 9;
            for(int i = 0; i < digits.length; i++) {
                for(int j = max; j > digits[i] - '0'; j--) {
                    if(lastIndex[j] > i) {
                        char tmp = digits[i];
                        digits[i] = digits[lastIndex[j]];
                        digits[lastIndex[j]] = tmp;
                        return Integer.valueOf(new String(digits));
                    }
                }
                max = digits[i] - '0';
            }
            return num;
        }
    }
}
