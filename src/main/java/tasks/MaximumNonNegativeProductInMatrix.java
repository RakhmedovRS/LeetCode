package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Sep-20
 */
@LeetCode(id = 1594, name = "Maximum Non Negative Product in a Matrix", url = "https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/")
public class MaximumNonNegativeProductInMatrix
{
	public int maxProductPath(int[][] grid)
	{
		long[] max = new long[]{-1};
		dfs(grid, 0, 0, max, grid[0][0]);
		return (int) (max[0] % 1_000_000_007);
	}

	private void dfs(int[][] grid, int row, int column, long[] max, long current)
	{
		if (row == grid.length - 1 && column == grid[row].length - 1)
		{
			max[0] = Math.max(max[0], current);
			return;
		}

		if (grid[row][column] == 0)
		{
			max[0] = Math.max(max[0], 0);
			return;
		}

		if (row + 1 < grid.length)
		{
			dfs(grid, row + 1, column, max, current * grid[row + 1][column]);
		}

		if (column + 1 < grid[row].length)
		{
			dfs(grid, row, column + 1, max, current * grid[row][column + 1]);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumNonNegativeProductInMatrix().maxProductPath(new int[][]
				{
						{1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2},
						{-2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0},
						{-4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1},
						{-3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2},
						{3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3},
						{2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0},
						{4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1},
						{-3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4},
						{-3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4},
						{2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4},
						{2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3},
						{1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0},
						{3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3}
				}));

		System.out.println(new MaximumNonNegativeProductInMatrix().maxProductPath(new int[][]
				{
						{1, 3},
						{0, -4}
				}));

		System.out.println(new MaximumNonNegativeProductInMatrix().maxProductPath(new int[][]
				{
						{1, -2, 1},
						{1, -2, 1},
						{3, -4, 1}
				}));

		System.out.println(new MaximumNonNegativeProductInMatrix().maxProductPath(new int[][]
				{
						{-1, -2, -3},
						{-2, -3, -3},
						{-3, -3, -2},
				}));
	}
}
