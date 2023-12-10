package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(
		id = 576,
		name = "Out of Boundary Paths",
		url = "https://leetcode.com/problems/out-of-boundary-paths/",
		difficulty = Difficulty.MEDIUM
)
public class OutOfBoundaryPaths {
	public int findPaths(int rows, int columns, int maxMove, int startRow, int startColumn) {
		Long[][][] memo = new Long[rows][columns][maxMove + 1];
		dfs(startRow, startColumn, rows, columns, maxMove, memo);
		return (int) (memo[startRow][startColumn][maxMove] % 1_000_000_007);
	}

	private long dfs(int row, int column, int rows, int columns, int maxMove, Long[][][] memo) {
		if (maxMove < 0) {
			return 0;
		}

		if (row < 0 || row == rows || column < 0 || column == columns) {
			return 1;
		}

		if (memo[row][column][maxMove] != null) {
			return memo[row][column][maxMove];
		}

		long count = dfs(row - 1, column, rows, columns, maxMove - 1, memo)
				+ dfs(row + 1, column, rows, columns, maxMove - 1, memo)
				+ dfs(row, column - 1, rows, columns, maxMove - 1, memo)
				+ dfs(row, column + 1, rows, columns, maxMove - 1, memo);

		memo[row][column][maxMove] = count % 1_000_000_007;
		return memo[row][column][maxMove];
	}
}
