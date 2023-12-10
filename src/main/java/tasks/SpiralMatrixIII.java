package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(
		id = 885,
		name = "Spiral Matrix III",
		url = "https://leetcode.com/problems/spiral-matrix-iii/",
		difficulty = Difficulty.MEDIUM
)
public class SpiralMatrixIII {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[] pos = {0};
		int[][] points = new int[R * C][];
		int[] currentPos = new int[]{r0, c0};
		int steps = 0;
		int currentSteps;
		while (steps < Math.max(R, C) * 2) {
			//right
			steps++;
			currentSteps = 0;
			while (currentSteps++ < steps) {
				addCoordinates(points, currentPos, pos, R, C);
				currentPos[1]++;
			}

			//down
			currentSteps = 0;
			while (currentSteps++ < steps) {
				addCoordinates(points, currentPos, pos, R, C);
				currentPos[0]++;
			}

			//left
			steps++;
			currentSteps = 0;
			while (currentSteps++ < steps) {
				addCoordinates(points, currentPos, pos, R, C);
				currentPos[1]--;
			}

			//up
			currentSteps = 0;
			while (currentSteps++ < steps) {
				addCoordinates(points, currentPos, pos, R, C);
				currentPos[0]--;
			}
		}

		return points;
	}

	private void addCoordinates(int[][] points, int[] point, int[] pos, int rows, int columns) {
		if (point[0] >= 0 && point[0] < rows && point[1] >= 0 && point[1] < columns) {
			points[pos[0]++] = new int[]{point[0], point[1]};
		}
	}
}
