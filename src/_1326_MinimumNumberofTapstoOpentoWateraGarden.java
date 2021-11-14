public class _1326_MinimumNumberofTapstoOpentoWateraGarden {
    class Solution {
        public int minTaps(int n, int[] ranges) {
            int[] arr = new int[n + 1];
            for(int i = 0; i < ranges.length; i++) {
                if(ranges[i] == 0) continue;
                int left = Math.max(0, i - ranges[i]);
                arr[left] = Math.max(arr[left], i + ranges[i]);
            }
            int res = 0;
            for(int i = 0, cur = 0, max = 0; i < arr.length; i++) {
                if(i > max) {
                    return -1;
                }
                if(i > cur) {
                    res++;
                    cur = max;
                }
                max = Math.max(max, arr[i]);
            }
            return res;
        }
    }
}
