package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-02
 */
@LeetCode(
		id = 3071,
		name = "Minimum Operations to Write the Letter Y on a Grid",
		url = "https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToWriteTheLetterYOnGrid {
	public int minimumOperationsToWriteY(int[][] grid) {
		int zeroes = numOps(cloneGrid(grid), 0);
		int ones = numOps(cloneGrid(grid), 1);
		int twos = numOps(cloneGrid(grid), 2);
		return Math.min(zeroes, Math.min(ones, twos));
	}

	private int numOps(int[][] grid, int targetNum) {
		int rows = grid.length;
		int columns = grid[0].length;
		int mid = rows / 2 + 1;
		int ops = 0;
		//left corner to mid
		int row = 0;
		int column = 0;
		boolean[][] immutable = new boolean[rows][columns];
		while (row < mid && column < mid) {
			immutable[row][column] = true;
			if (grid[row][column] != targetNum) {
				grid[row][column] = targetNum;
				ops++;
			}
			row++;
			column++;
		}

		//right corner to mid
		row = 0;
		column = columns - 1;
		while (row < mid && column >= mid) {
			immutable[row][column] = true;
			if (grid[row][column] != targetNum) {
				grid[row][column] = targetNum;
				ops++;
			}
			row++;
			column--;
		}

		//mid to bottom
		row = mid;
		while (row < rows) {
			immutable[row][mid - 1] = true;
			if (grid[row][mid - 1] != targetNum) {
				grid[row][mid - 1] = targetNum;
				ops++;
			}
			row++;
		}

		int zeroes = 0;
		int ones = 0;
		int twos = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (!immutable[r][c]) {
					if (grid[r][c] == 0) {
						zeroes++;
					} else if (grid[r][c] == 1) {
						ones++;
					} else {
						twos++;
					}
				}
			}
		}

		if (targetNum == 0) {
			ops += zeroes;
			ops += Math.min(ones, twos);
		} else if (targetNum == 1) {
			ops += ones;
			ops += Math.min(zeroes, twos);
		} else {
			ops += twos;
			ops += Math.min(ones, zeroes);
		}

		return ops;
	}

	private int[][] cloneGrid(int[][] grid) {
		int rows = grid.length;
		int[][] copy = new int[rows][];
		for (int row = 0; row < rows; row++) {
			copy[row] = Arrays.copyOf(grid[row], grid[row].length);
		}
		return copy;
	}
}