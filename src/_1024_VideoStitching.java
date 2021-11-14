public class _1024_VideoStitching {
    class Solution {
        public int videoStitching(int[][] clips, int time) {
            int[] arr = new int[time + 1];
            for(int i = 0; i < clips.length; i++) {
                int start = clips[i][0];
                int end = clips[i][1];
                if(start <= time) {
                    arr[start] = Math.max(arr[start], end);
                }
            }
            int res = 0;
            for(int i = 0, cur = 0, next = 0; i < arr.length; i++) {
                if(i > next) {
                    return -1;
                }
                if(i > cur) {
                    res++;
                    cur = next;
                }
                next = Math.max(next, arr[i]);
            }
            return res;
        }
    }
}
