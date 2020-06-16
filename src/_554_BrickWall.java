import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _554_BrickWall {
    /**
     * Time O(n)
     * Space O(m)
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall) {
            int width = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                width += list.get(i);
                map.put(width, map.getOrDefault(width, 0) + 1);
            }
        }
        return wall.size() - (map.size() == 0 ? 0 : Collections.max(map.values()));
    }
}
