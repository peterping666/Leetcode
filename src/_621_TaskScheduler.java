public class _621_TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            int max = 0;
            int maxCount = 0;

            for (char task: tasks) {
                count[task - 'A']++;
                if (count[task - 'A'] > max) {
                    max = count[task - 'A'];
                    maxCount = 1;
                } else if (count[task - 'A'] == max) {
                    maxCount++;
                }
            }
            int numberOfGaps = max - 1;
            int gapLength = n + 1;
            return Math.max(tasks.length, numberOfGaps * gapLength + maxCount);
        }
    }
}
