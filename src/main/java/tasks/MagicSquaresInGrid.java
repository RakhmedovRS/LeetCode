package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(id = 840, name = "Magic Squares In Grid", url = "https://leetcode.com/problems/magic-squares-in-grid/")
public class MagicSquaresInGrid {
	public int numMagicSquaresInside(int[][] grid) {
		if (grid.length < 3 || grid[0].length < 3) {
			return 0;
		}

		int answer = 0;
		for (int row = 1; row < grid.length - 1; row++) {
			for (int column = 1; column < grid[row].length - 1; column++) {
				if (grid[row][column] == 5 && isMagicGrid(grid, row, column)) {
					answer++;
				}
			}
		}

		return answer;
	}


	private boolean isMagicGrid(int[][] grid, int row, int column) {
		int[] memo = new int[16];
		for (int r = row - 1; r < row + 2; r++) {
			for (int c = column - 1; c < column + 2; c++) {
				memo[grid[r][c]]++;
				if (memo[grid[r][c]] > 1 || grid[r][c] > 9 || grid[r][c] == 0) {
					return false;
				}
			}
		}


		int row1 = grid[row - 1][column - 1] + grid[row - 1][column] + grid[row - 1][column + 1];
		int row2 = grid[row][column - 1] + grid[row][column] + grid[row][column + 1];
		int row3 = grid[row + 1][column - 1] + grid[row + 1][column] + grid[row + 1][column + 1];
		int column1 = grid[row - 1][column - 1] + grid[row][column - 1] + grid[row + 1][column - 1];
		int column2 = grid[row - 1][column] + grid[row][column] + grid[row + 1][column];
		int column3 = grid[row - 1][column + 1] + grid[row][column + 1] + grid[row + 1][column + 1];
		int diagonal1 = grid[row - 1][column - 1] + grid[row][column] + grid[row + 1][column + 1];
		int diagonal2 = grid[row + 1][column - 1] + grid[row][column] + grid[row - 1][column + 1];

		return row1 == row2
				&& row2 == row3
				&& row3 == column1
				&& column1 == column2
				&& column2 == column3
				&& column3 == diagonal1
				&& diagonal1 == diagonal2;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}};
		System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(matrix));

		matrix = new int[][]{{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
		System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(matrix));
	}
}
