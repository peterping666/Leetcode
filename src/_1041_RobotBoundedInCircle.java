public class _1041_RobotBoundedInCircle {
    class Solution1 {
        public boolean isRobotBounded(String instructions) {
            int x = 0;
            int y = 0;
            int dir_x = 0;
            int dir_y = 1;
            for(int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if(c == 'L') {
                    int tmp_x = dir_x;
                    dir_x = -dir_y;
                    dir_y = tmp_x;
                } else if(c == 'R') {
                    int tmp_x = dir_x;
                    dir_x = dir_y;
                    dir_y = -tmp_x;
                } else {
                    x += dir_x;
                    y += dir_y;
                }
            }
            return (x == 0 && y == 0) || !(dir_x == 0 && dir_y == 1);
        }
    }

    class Solution2 {
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


