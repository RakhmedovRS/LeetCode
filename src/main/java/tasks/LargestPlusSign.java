package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jul-20
 */
@LeetCode(
		id = 764,
		name = "Largest Plus Sign",
		url = "https://leetcode.com/problems/largest-plus-sign/",
		difficulty = Difficulty.MEDIUM
)
public class LargestPlusSign {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int max = 0;
		boolean found = true;
		int row = 0;
		int column = 0;
		int steps = 0;
		int[][] grid = createGridAndSetMines(N, mines);
		outer:
		while (found) {
			found = false;
			for (int r = row; r < N - steps; r++) {
				for (int c = column; c < N - steps; c++) {
					if (grid[r][c] == 0) {
						int R = r;
						int C = c;
						int S = steps + 1;
						//left
						while (C >= 0 && grid[R][C] == 0 && S != 0) {
							C--;
							S--;
						}
						if (S != 0) {
							continue;
						}

						R = r;
						C = c;
						S = steps + 1;
						//right
						while (C < grid[R].length && grid[R][C] == 0 && S != 0) {
							C++;
							S--;
						}
						if (S != 0) {
							continue;
						}

						R = r;
						C = c;
						S = steps + 1;
						//down
						while (R < grid.length && grid[R][C] == 0 && S != 0) {
							R++;
							S--;
						}
						if (S != 0) {
							continue;
						}

						R = r;
						C = c;
						S = steps + 1;
						//up
						while (R >= 0 && grid[R][C] == 0 && S != 0) {
							R--;
							S--;
						}
						if (S != 0) {
							continue;
						}

						max = steps + 1;
						row++;
						column++;
						steps++;
						found = true;
						continue outer;
					}
				}
			}
		}

		return max;
	}

	private int[][] createGridAndSetMines(int N, int[][] mines) {
		int[][] grid = new int[N][N];
		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 1;
		}

		return grid;
	}
}
