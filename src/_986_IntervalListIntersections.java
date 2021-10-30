import java.util.ArrayList;
import java.util.List;

public class    _986_IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            List<int[]> res= new ArrayList<>();
            int firstIndex = 0;
            int secondIndex = 0;
            while(firstIndex < firstList.length && secondIndex < secondList.length) {
                int low = Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
                int high = Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);
                if(low <= high) {
                    res.add(new int[]{low, high});
                }
                if(firstList[firstIndex][1] <= secondList[secondIndex][1]) {
                    firstIndex++;
                } else {
                    secondIndex++;
                }
            }
            return res.toArray(new int[0][]);
        }
    }
}
