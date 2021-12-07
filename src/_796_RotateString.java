public class _796_RotateString {
    class Solution {
        public boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (s+s).contains(goal);
        }
    }

    class Solution2 {
        public boolean rotateString(String s, String goal) {
            return s.length() == goal.length() && (goal+goal).contains(s);
        }
    }
}
