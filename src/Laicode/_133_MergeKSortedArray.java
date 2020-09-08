package Laicode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _133_MergeKSortedArray {
    public class Solution {
        public int[] merge(int[][] arrayOfArrays) {
            Queue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point a, Point b) {
                    if(a.value == b.value) {
                        return 0;
                    }
                    return a.value < b.value ? -1 : 1;
                }
            });
            int length = 0;
            for(int i = 0; i < arrayOfArrays.length; i++) {
                if(arrayOfArrays[i].length != 0) {
                    length += arrayOfArrays[i].length;
                    minHeap.offer(new Point(arrayOfArrays[i][0], i, 0));
                }

            }
            int[] res = new int[length];
            int index = 0;
            while(!minHeap.isEmpty()) {
                Point cur = minHeap.poll();
                res[index++] = cur.value;
                if(cur.col + 1 < arrayOfArrays[cur.row].length) {
                    minHeap.offer(new Point(arrayOfArrays[cur.row][cur.col + 1], cur.row, cur.col + 1));
                }
            }
            return res;
        }

        class Point {
            int value;
            int row;
            int col;

            Point(int val, int r, int c) {
                value = val;
                row = r;
                col = c;
            }
        }
    }

}
