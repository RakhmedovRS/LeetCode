package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-11
 */
@LeetCode(
		id = 3142,
		name = "Check if Grid Satisfies Conditions",
		url = "https://leetcode.com/problems/check-if-grid-satisfies-conditions/description/",
		difficulty = Difficulty.EASY
)
public class CheckIfGridSatisfiesConditions {
	public boolean satisfiesConditions(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (column + 1 < columns && grid[row][column] == grid[row][column + 1]) {
					return false;
				}

				if (row + 1 < rows && grid[row][column] != grid[row + 1][column]) {
					return false;
				}
			}
		}
		return true;
	}
}