package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/23/2020
 */
@LeetCode(
		id = 1267,
		name = "Count Servers that Communicate",
		url = "https://leetcode.com/problems/count-servers-that-communicate/",
		difficulty = Difficulty.MEDIUM
)
public class CountServersThatCommunicate {
	public int countServers(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;

		int[] rowServers = new int[rows];
		int[] columnServers = new int[columns];

		int count = 0;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] == 1) {
					rowServers[row]++;
					columnServers[column]++;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] == 1 && (rowServers[row] > 1 || columnServers[column] > 1)) {
					count++;
				}
			}
		}

		return count;
	}
}
