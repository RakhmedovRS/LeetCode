package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 2/12/2021
 */
@LeetCode(
		id = 489,
		name = "Robot Room Cleaner",
		url = "https://leetcode.com/problems/robot-room-cleaner/",
		difficulty = Difficulty.HARD,
		premium = true
)
public class RobotRoomCleaner {
	interface Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current cell.
		boolean move();

		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		void turnLeft();

		void turnRight();

		// Clean the current cell.
		void clean();
	}

	public void cleanRoom(Robot robot) {
		explore(robot, 0, 0, new HashSet<>(), new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}, 0);
	}

	private void explore(Robot robot, int row, int column, Set<String> visited, int[][] directions, int dir) {
		String key = row + "|" + column;
		visited.add(key);

		robot.clean();

		String nextKey;
		int nextDir;
		int nextRow;
		int nextColumn;
		for (int i = 0; i < 4; i++) {
			nextDir = (dir + i) % 4;
			nextRow = row + directions[nextDir][0];
			nextColumn = column + directions[nextDir][1];
			nextKey = nextRow + "|" + nextColumn;

			if (!visited.contains(nextKey) && robot.move()) {
				explore(robot, nextRow, nextColumn, visited, directions, nextDir);
				goBack(robot);
			}

			robot.turnLeft();
		}
	}

	private void goBack(Robot robot) {
		robot.turnLeft();
		robot.turnLeft();
		robot.move();
		robot.turnLeft();
		robot.turnLeft();
	}
}
