import java.util.TreeMap;

public class _729_MyCalendarI {
    class MyCalendar {

        private TreeMap<Integer, Integer> treemap;

        public MyCalendar() {
            treemap = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer before = treemap.floorKey(start);
            if(before != null && start < treemap.get(before)) {
                return false;
            }
            Integer after = treemap.ceilingKey(start);
            if(after != null && end > after) {
                return false;
            }
            treemap.put(start, end);
            return true;
        }
    }
}
