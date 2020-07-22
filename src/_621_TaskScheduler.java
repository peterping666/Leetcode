import java.util.Arrays;

public class _621_TaskScheduler {
    class Solution1 {
        public int leastInterval(char[] tasks, int n) {
            int[] counts = new int[26];
            int[] index = new int[26];
            for(char task : tasks) {
                counts[task - 'A']++;
            }
            int count = tasks.length;
            int res = 0;
            while(count > 0) {
                int maxCount = 0;
                int maxIndex = -1;
                for(int i = 0; i < 26; i++) {
                    if(counts[i] > maxCount && res >= index[i]) {
                        maxCount = counts[i];
                        maxIndex = i;
                    }
                }
                if(maxIndex != -1) {
                    count--;
                    counts[maxIndex]--;
                    index[maxIndex] += n+1;
                }
                res++;
            }
            return res;
        }
    }

    /**
     *
     */
    class Solution2 {
        public int leastInterval(char[] tasks, int n) {
            int[] frequencies = new int[26];
            for (int t : tasks) {
                frequencies[t - 'A']++;
            }

            Arrays.sort(frequencies);

            // max frequency
            int f_max = frequencies[25];
            int idle_time = (f_max - 1) * n;

            for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
                idle_time -= Math.min(f_max - 1, frequencies[i]);
            }
            idle_time = Math.max(0, idle_time);

            return idle_time + tasks.length;
        }
    }
}
