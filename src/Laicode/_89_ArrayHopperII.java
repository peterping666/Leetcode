package Laicode;

public class _89_ArrayHopperII {
    public class Solution1 {
        public int minJump(int[] array) {
            if(array.length == 1) {
                return 0;
            }
            int count = 1;
            int max = array[0];
            int next = array[0];
            for(int i = 1; i < array.length; i++) {
                if(max < i) {
                    return -1;
                }
                if(i > next) {
                    count++;
                    next = max;
                }
                max = Math.max(max, i + array[i]);
            }
            return count;
        }
    }

    public class Solution2 {
        public int minJump(int[] array) {
            int jump = 0;
            int next = 0;
            int cur = 0;
            for(int i = 0; i < array.length; i++) {
                if(i > cur) {
                    if(cur == next) {
                        return -1;
                    }
                    jump++;
                    cur = next;
                }
                next = Math.max(next, i + array[i]);
            }
            return jump;
        }
    }

}
