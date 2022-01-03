public class _547_NumberofProvinces {

    /**
     * Time O(n^2)
     * Space O(n)
     */
    class Solution1 {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int res = 0;
            boolean[] visited = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    dfs(isConnected, i, visited);
                    visited[i] = true;
                    res++;
                }
            }
            return res;
        }

        private void dfs(int[][] isConnected, int i, boolean[] visited) {
            for(int j = 0; j < isConnected.length; j++) {
                if(isConnected[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(isConnected, j, visited);
                }
            }
        }
    }
}

