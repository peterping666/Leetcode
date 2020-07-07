import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class _489_RobotRoomCleaner {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet();

    public void cleanRoom(Robot robot) {
        backtrack(robot, 0, 0, 0);
    }

    public void backtrack(Robot robot, int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                backtrack(robot, newRow, newCol, newD);
                goBack(robot);
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
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
