package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Apr-20
 */
@LeetCode(
		id = 329,
		name = "Longest Increasing Path in a Matrix",
		url = "https://leetcode.com/problems/longest-increasing-path-in-a-matrix/",
		difficulty = Difficulty.HARD
)
public class LongestIncreasingPathInMatrix
{
	public int longestIncreasingPath(int[][] matrix)
	{
		int rows = matrix.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = matrix[0].length;

		int max = 0;

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				max = Math.max(max, dfs(Long.MAX_VALUE, row, column, rows, columns, matrix, new Integer[rows][columns]));
			}
		}

		return max;
	}

	private int dfs(long value, int row, int column, int rows, int columns, int[][] matrix, Integer[][] memo)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || value <= matrix[row][column])
		{
			return 0;
		}

		if (memo[row][column] != null)
		{
			return memo[row][column];
		}

		int left = 1 + dfs(matrix[row][column], row - 1, column, rows, columns, matrix, memo);
		int right = 1 + dfs(matrix[row][column], row + 1, column, rows, columns, matrix, memo);
		int up = 1 + dfs(matrix[row][column], row, column - 1, rows, columns, matrix, memo);
		int down = 1 + dfs(matrix[row][column], row, column + 1, rows, columns, matrix, memo);

		memo[row][column] = Math.max(left, Math.max(right, Math.max(up, down)));

		return memo[row][column];
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
				{19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
				{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
				{39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
				{40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
				{59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
				{60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
				{79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
				{80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
				{99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
				{100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
				{119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
				{120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
				{139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(matrix));

		matrix = new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		};
		System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(matrix));
	}
}
