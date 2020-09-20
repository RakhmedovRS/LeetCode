import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Sep-20
 */
@LeetCode(id = 980, name = "Unique Paths III", url = "https://leetcode.com/problems/unique-paths-iii/")
public class UniquePathsIII
{
	public int uniquePathsIII(int[][] grid)
	{
		int zeroes = 0;
		int rows = grid.length;
		int columns = grid[0].length;
		int[] start = null;
		int[] end = null;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 0)
				{
					zeroes++;
				}
				else if (grid[row][column] == 1)
				{
					start = new int[]{row, column};
				}
				else if (grid[row][column] == 2)
				{
					end = new int[]{row, column};
				}
			}
		}

		if (start[0] == end[0] && start[1] == end[1])
		{
			return 0;
		}

		return dfs(grid, start[0] - 1, start[1], end, zeroes, rows, columns) +
			dfs(grid, start[0] + 1, start[1], end, zeroes, rows, columns) +
			dfs(grid, start[0], start[1] - 1, end, zeroes, rows, columns) +
			dfs(grid, start[0], start[1] + 1, end, zeroes, rows, columns);
	}

	private int dfs(int[][] grid, int row, int column, int[] end, int zeroes, int rows, int columns)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] < 0 || grid[row][column] == 1)
		{
			return 0;
		}

		if (zeroes == 0)
		{
			return row == end[0] && column == end[1] ? 1 : 0;
		}

		int temp = grid[row][column];
		grid[row][column] = Integer.MIN_VALUE;
		int count = dfs(grid, row - 1, column, end, zeroes - 1, rows, columns) +
			dfs(grid, row + 1, column, end, zeroes - 1, rows, columns) +
			dfs(grid, row, column - 1, end, zeroes - 1, rows, columns) +
			dfs(grid, row, column + 1, end, zeroes - 1, rows, columns);

		grid[row][column] = temp;
		return count;
	}

	public static void main(String[] args)
	{
		int[][] grid = new int[][]
			{
				{1, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 2, -1}
			};

		System.out.println(new UniquePathsIII().uniquePathsIII(grid));
	}
}
