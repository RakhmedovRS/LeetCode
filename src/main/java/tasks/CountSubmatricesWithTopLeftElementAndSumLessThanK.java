package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-02
 */
@LeetCode(
		id = 3070,
		name = "Count Submatrices with Top-Left Element and Sum Less Than k",
		url = "https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/",
		difficulty = Difficulty.MEDIUM
)
public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
	public int countSubmatrices(int[][] grid, int k) {
		int rows = grid.length;
		int columns = grid[0].length;

		int[][] leftToRight = new int[rows][columns];

		int count = 0;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				leftToRight[row][column] = grid[row][column] + (column - 1 >= 0 ? leftToRight[row][column - 1] : 0);
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				leftToRight[row][column] += (row - 1 >= 0 ? leftToRight[row - 1][column] : 0);
				if (leftToRight[row][column] <= k) {
					count++;
				}
			}
		}

		return count;
	}
}