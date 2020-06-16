import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _406_QueueReconstructionbyHeight {
    /**
     * Time O(n^2)
     * Space O(n)
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[0][]);
    }
}
