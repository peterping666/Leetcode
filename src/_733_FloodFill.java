public class _733_FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int m = image.length;
            int n = image[0].length;
            dfs(image, sr, sc, image[sr][sc], newColor, new boolean[m][n]);
            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int color, int newColor, boolean[][] visited) {
            int m = image.length;
            int n = image[0].length;
            if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != color || visited[sr][sc]) {
                return;
            }
            image[sr][sc] = newColor;
            visited[sr][sc] = true;
            dfs(image, sr + 1, sc, color, newColor, visited);
            dfs(image, sr - 1, sc, color, newColor, visited);
            dfs(image, sr, sc + 1, color, newColor, visited);
            dfs(image, sr, sc - 1, color, newColor, visited);
        }
    }
}
