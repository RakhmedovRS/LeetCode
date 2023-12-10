package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(
		id = 62,
		name = "Unique Paths",
		url = "https://leetcode.com/problems/unique-paths/",
		difficulty = Difficulty.MEDIUM
)
public class UniquePaths {
	public int uniquePaths(int rows, int columns) {
		int[][] grid = new int[rows][columns];
		Arrays.fill(grid[0], 1);
		for (int row = 0; row < rows; row++) {
			grid[row][0] = 1;
		}

		for (int row = 1; row < rows; row++) {
			for (int column = 1; column < columns; column++) {
				grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
			}
		}

		return grid[rows - 1][columns - 1];
	}
}
