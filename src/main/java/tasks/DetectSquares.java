package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/19/2021
 */
@LeetCode(
		id = 2013,
		name = "Detect Squares",
		url = "https://leetcode.com/problems/detect-squares/",
		difficulty = Difficulty.MEDIUM
)
class DetectSquares {
	int[][] grid;

	int size = 1001;

	public DetectSquares() {
		grid = new int[size][size];
	}

	public void add(int[] point) {
		int x = point[0];
		int y = point[1];
		grid[x][y]++;
	}

	public int count(int[] point) {
		int count = 0;
		int x = point[0];
		int y = point[1];

		int center = 1;
		for (int step = 1; step < size; step++) {
			//up left
			if (x - step >= 0 && y - step >= 0) {
				int upLeftCorner = grid[x - step][y - step];
				int centerUp = grid[x - step][y];
				int leftCenter = grid[x][y - step];
				count += upLeftCorner * centerUp * leftCenter * center;
			}

			//up right
			if (x - step >= 0 && y + step < size) {
				int centerUp = grid[x - step][y];
				int upRightCorner = grid[x - step][y + step];
				int rightCenter = grid[x][y + step];
				count += centerUp * upRightCorner * rightCenter * center;
			}

			//left down
			if (x + step < size && y - step >= 0) {
				int leftCenter = grid[x][y - step];
				int downLeftCorner = grid[x + step][y - step];
				int downCenter = grid[x + step][y];
				count += leftCenter * downLeftCorner * downCenter * center;
			}

			//right down
			if (x + step < size && y + step < size) {
				int downCenter = grid[x + step][y];
				int rightCenter = grid[x][y + step];
				int downRightCorner = grid[x + step][y + step];
				count += downCenter * downRightCorner * rightCenter * center;
			}
		}

		return count;
	}
}
