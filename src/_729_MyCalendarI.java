import java.util.TreeMap;

public class _729_MyCalendarI {
    class MyCalendar {
        TreeMap<Integer, Integer> calender;
        public MyCalendar() {
            calender = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer floorKey = calender.floorKey(start);
            if(floorKey != null && calender.get(floorKey) > start) return false;
            Integer ceilingKey = calender.ceilingKey(start);
            if(ceilingKey != null && ceilingKey < end) return false;
            calender.put(start, end);
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
