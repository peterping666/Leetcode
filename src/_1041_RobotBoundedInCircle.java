public class _1041_RobotBoundedInCircle {
    class Solution {
        public boolean isRobotBounded(String instructions) {
            int index = 0;
            int x = 0;
            int y = 0;
            int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
            for(int i = 0; i < instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if(ch == 'R') {
                    index = (index + 1) % 4;
                } else if(ch == 'L') {
                    index = (index + 3) % 4;
                } else {
                    x += dir[index][0];
                    y += dir[index][1];
                }
            }
            return x == 0 && y == 0 || index > 0;
        }
    }
}
