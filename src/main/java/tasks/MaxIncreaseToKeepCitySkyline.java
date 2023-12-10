package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/22/2021
 */
@LeetCode(
		id = 807,
		name = "Max Increase to Keep City Skyline",
		url = "https://leetcode.com/problems/max-increase-to-keep-city-skyline/",
		difficulty = Difficulty.MEDIUM
)
public class MaxIncreaseToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int answer = 0;
		int rows = grid.length;
		if (rows == 0) {
			return answer;
		}
		int columns = grid[0].length;

		int[] rowMaxes = new int[rows];
		int[] columnMaxes = new int[columns];

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				rowMaxes[row] = Math.max(rowMaxes[row], grid[row][column]);
				columnMaxes[column] = Math.max(columnMaxes[column], grid[row][column]);
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				answer += Math.min(rowMaxes[row], columnMaxes[column]) - grid[row][column];
			}
		}

		return answer;
	}
}
