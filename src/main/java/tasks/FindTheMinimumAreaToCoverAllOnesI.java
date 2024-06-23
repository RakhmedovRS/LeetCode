package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-22
 */
@LeetCode(
		id = 3195,
		name = "Find the Minimum Area to Cover All Ones I",
		url = "https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheMinimumAreaToCoverAllOnesI {
	public int minimumArea(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int min = rows * columns;
		int left = 0;
		int right = columns - 1;
		int up = 0;
		int bottom = rows - 1;
		boolean shifted = true;
		while (shifted) {
			shifted = false;
			boolean seenOne = false;
			for (int row = up; row <= bottom; row++) {
				if (grid[row][left] == 1) {
					seenOne = true;
					break;
				}
			}
			if (!seenOne) {
				left++;
				shifted = true;
			}

			seenOne = false;
			for (int row = up; row <= bottom; row++) {
				if (grid[row][right] == 1) {
					seenOne = true;
					break;
				}
			}
			if (!seenOne) {
				right--;
				shifted = true;
			}

			seenOne = false;
			for (int column = left; column <= right; column++) {
				if (grid[up][column] == 1) {
					seenOne = true;
					break;
				}
			}
			if (!seenOne) {
				up++;
				shifted = true;
			}

			seenOne = false;
			for (int column = left; column <= right; column++) {
				if (grid[bottom][column] == 1) {
					seenOne = true;
					break;
				}
			}
			if (!seenOne) {
				bottom--;
				shifted = true;
			}

			min = Math.min(min, (1 + bottom - up) * (1 + right - left));
		}
		return min;
	}
}