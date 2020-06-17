import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangleII {
    /**
     * Time o(K^2)
     * Space O(k)
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            for(int j = 1; j < i; j++) {
                newList.add(list.get(j - 1) + list.get(j));
            }
            newList.add(1);
            list = newList;
        }
        return list;
    }
}
