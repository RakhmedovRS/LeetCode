import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 2/9/2021
 */
@LeetCode(
	id = 694,
	name = "Number of Distinct Islands",
	url = "https://leetcode.com/problems/number-of-distinct-islands/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class NumberOfDistinctIslands
{
	class Island
	{
		int minRow = Integer.MAX_VALUE;
		int maxRow = Integer.MIN_VALUE;
		int minColumn = Integer.MAX_VALUE;
		int maxColumn = Integer.MIN_VALUE;
		List<int[]> coordinates = new ArrayList<>();
		boolean[][] table;

		public void addCoordinate(int row, int column)
		{
			coordinates.add(new int[]{row, column});
			minRow = Math.min(minRow, row);
			maxRow = Math.max(maxRow, row);
			minColumn = Math.min(minColumn, column);
			maxColumn = Math.max(maxColumn, column);
		}

		public String getTable()
		{
			if (table == null)
			{
				table = new boolean[maxRow - minRow + 1][maxColumn - minColumn + 1];
				for (int[] coordinate : coordinates)
				{
					table[coordinate[0] - minRow][coordinate[1] - minColumn] = true;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int row = 0; row < table.length; row++)
			{
				for (int column = 0; column < table[0].length; column++)
				{
					sb.append(table[row][column] ? "X" : " ");
				}
				sb.append("|");
			}
			return sb.toString();
		}
	}

	public int numDistinctIslands(int[][] grid)
	{
		int islands = 0;
		int rows = grid.length;
		if (rows == 0)
		{
			return islands;
		}
		int columns = grid[0].length;

		boolean[][] visited = new boolean[rows][columns];
		Set<String> unique = new HashSet<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (!visited[row][column] && grid[row][column] == 1)
				{
					Island island = new Island();
					dfs(row, column, rows, columns, visited, grid, island);
					if (unique.add(island.getTable()))
					{
						islands++;
					}
				}
			}
		}

		return islands;
	}

	private void dfs(int row, int column, int rows, int columns, boolean[][] visited, int[][] grid, Island island)
	{
		if (row >= 0 && row < rows && column >= 0 && column < columns && !visited[row][column] && grid[row][column] == 1)
		{
			visited[row][column] = true;
			island.addCoordinate(row, column);
			dfs(row + 1, column, rows, columns, visited, grid, island);
			dfs(row, column - 1, rows, columns, visited, grid, island);
			dfs(row - 1, column, rows, columns, visited, grid, island);
			dfs(row, column + 1, rows, columns, visited, grid, island);
		}
	}
}
