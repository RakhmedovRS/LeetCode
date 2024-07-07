package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3212,
		name = "Count Submatrices With Equal Frequency of X and Y",
		url = "https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountSubmatricesWithEqualFrequencyOfXAndY {
	class Point {
		int x;
		int y;
	}

	public int numberOfSubmatrices(char[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		Point[][] points = new Point[rows][columns];
		Point dummy = new Point();
		for (int row = 1; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				Point prevPoint = column - 1 >= 0 ? points[row][column - 1] : dummy;
				Point newPoint = new Point();
				newPoint.x += prevPoint.x;
				newPoint.y += prevPoint.y;
				if (grid[row][column] == 'X') {
					newPoint.x++;
				} else if (grid[row][column] == 'Y') {
					newPoint.y++;
				}
				points[row][column] = newPoint;
			}
		}

		int ans = 0;
		int x = 0;
		int y = 0;
		for (int column = 0; column < columns; column++) {
			if (grid[0][column] == 'X') {
				x++;
			} else if (grid[0][column] == 'Y') {
				y++;
			}

			if (x > 0 && x == y) {
				ans++;
			}

			int tempX = x;
			int tempY = y;
			for (int row = 1; row < rows; row++) {
				tempX += points[row][column].x;
				tempY += points[row][column].y;

				if (tempX > 0 && tempX == tempY) {
					ans++;
				}
			}
		}

		return ans;
	}
}