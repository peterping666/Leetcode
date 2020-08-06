public class _526_BeautifulArrangement {
    class Solution {

        public int countArrangement(int N) {
            boolean[] visited = new boolean[N + 1];
            return calculate(N, 1, visited);
        }
        public int calculate(int N, int pos, boolean[] visited) {
            if (pos > N) {
                return 1;
            }
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                    visited[i] = true;
                    count += calculate(N, pos + 1, visited);
                    visited[i] = false;
                }
            }
            return count;
        }
    }
}
