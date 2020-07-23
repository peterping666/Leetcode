package Laicode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _26_KthSmallestNumberInSortedMatrix {
    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b) {
                    return matrix[a[0]][a[1]] - matrix[b[0]][b[1]];
                }
            });
            int[][] dirs = {{1,0}, {0,1}};
            HashSet<Integer> seen = new HashSet<>();
            q.offer(new int[]{0,0});
            seen.add(0);
            while(!q.isEmpty() && k-- > 1) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < m && y < n && seen.add(x * n + y)) {
                        q.offer(new int[]{x,y});
                    }
                }
            }
            int[] index = q.peek();
            return matrix[index[0]][index[1]];
        }
    }

}
