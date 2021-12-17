public class _769_MaxChunksToMakeSorted {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int max = -1, res = 0;
            for(int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
                if(max == i) {
                    res++;
                }
            }
            return res;
        }
    }
}
