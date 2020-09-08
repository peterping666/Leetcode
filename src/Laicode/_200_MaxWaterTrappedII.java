package Laicode;

import java.util.*;

public class _200_MaxWaterTrappedII {
    public class Solution {
        public int maxTrapped(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            if(m < 3 || n < 3) {
                return 0;
            }
            Queue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    if(a.height == b.height) {
                        return 0;
                    }
                    return a.height < b.height ? -1 : 1;
                }
            });
            boolean[][] visited = new boolean[m][n];
            processBorder(matrix, visited, minHeap, m, n);
            int res = 0;
            while(!minHeap.isEmpty()) {
                Point cur = minHeap.poll();
                List<Point> neighbors = allNeighbors(cur, matrix, visited);
                for(Point nei : neighbors) {
                    res += Math.max(cur.height - nei.height, 0);
                    nei.height = Math.max(cur.height, nei.height);
                    minHeap.offer(nei);
                }
            }
            return res;
        }

        private void processBorder(int[][] matrix, boolean[][] visited, Queue<Point> minHeap, int m, int n) {
            for(int j = 0; j < n; j++) {
                minHeap.offer(new Point(0, j, matrix[0][j]));
                minHeap.offer(new Point(m - 1, j, matrix[m - 1][j]));
                visited[0][j] = true;
                visited[m - 1][j] = true;
            }

            for(int i = 1; i < m - 1; i++) {
                minHeap.offer(new Point(i, 0, matrix[i][0]));
                minHeap.offer(new Point(i, n - 1, matrix[i][n - 1]));
                visited[i][0] = true;
                visited[i][n - 1] = true;
            }
        }

        private List<Point> allNeighbors(Point cur, int[][] matrix, boolean[][] visited) {
            List<Point> neis = new ArrayList<>();
            if(cur.x + 1 < matrix.length && !visited[cur.x + 1][cur.y]) {
                neis.add(new Point(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if(cur.x - 1 >= 0 && !visited[cur.x - 1][cur.y]) {
                neis.add(new Point(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y]));
                visited[cur.x - 1][cur.y] = true;
            }
            if(cur.y + 1 < matrix[0].length && !visited[cur.x][cur.y + 1]) {
                neis.add(new Point(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
            if(cur.y - 1 >= 0 && !visited[cur.x][cur.y - 1]) {
                neis.add(new Point(cur.x, cur.y - 1, matrix[cur.x][cur.y - 1]));
                visited[cur.x][cur.y - 1] = true;
            }
            return neis;
        }

        class Point {
            int x;
            int y;
            int height;

            Point(int x, int y, int height) {
                this.x = x;
                this.y = y;
                this.height = height;
            }
        }
    }

}
