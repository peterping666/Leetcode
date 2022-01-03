import java.util.HashSet;
import java.util.Set;

public class _489_RobotRoomCleaner {
    class Solution {
        public void cleanRoom(Robot robot) {
            dfs(robot, 0, 0, 0, new HashSet<>());
        }

        private void dfs(Robot robot, int i, int j, int dir, Set<String> seen) {
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            robot.clean();
            seen.add(i + "-" + j);
            for(int k = 0; k < 4; k++) {
                int nextDir = (dir + k) % 4;
                int x = dirs[nextDir][0] + i;
                int y = dirs[nextDir][1] + j;
                if (!seen.contains(x + "-" + y) && robot.move()) {
                    dfs(robot, x, y, nextDir, seen);
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
                robot.turnRight();
            }
        }
    }
}

interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();
      public void turnLeft();
      public void turnRight();
      public void clean();
}
