public class _1419_MinimumNumberofFrogsCroaking {
    class Solution1 {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] count = new int[5];
            int res = 0;
            for(int i = 0; i < croakOfFrogs.length(); i++) {
                int index = "croak".indexOf(croakOfFrogs.charAt(i));
                if(index == 0) {
                    res = Math.max(res, ++count[0]);
                } else if(count[index-1] == count[index]) {
                    return -1;
                } else {
                    count[index]++;
                    if(index == 4) {
                        for(int j = 0; j < 5; j++) {
                            count[j]--;
                        }
                    }
                }
            }
            return count[0] == 0 ? res : -1;
        }
    }

    class Solution2 {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] cnt = new int[5];
            int frogs = 0, max_frogs = 0;
            for (int i = 0; i < croakOfFrogs.length(); ++i) {
                char ch = croakOfFrogs.charAt(i);
                int n = "croak".indexOf(ch);
                ++cnt[n];
                if (n == 0)
                    max_frogs = Math.max(max_frogs, ++frogs);
                else if (--cnt[n - 1] < 0)
                    return -1;
                else if (n == 4)
                    --frogs;
            }
            return frogs == 0 ? max_frogs : -1;
        }
    }
}
