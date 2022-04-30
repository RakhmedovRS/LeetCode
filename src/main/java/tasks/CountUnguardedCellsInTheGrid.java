package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 4/30/2022
 */
@LeetCode(
	id = 2257,
	name = "Count Unguarded Cells in the Grid",
	url = "https://leetcode.com/problems/count-unguarded-cells-in-the-grid/",
	difficulty = Difficulty.MEDIUM
)
public class CountUnguardedCellsInTheGrid
{
	public int countUnguarded(int rows, int columns, int[][] guards, int[][] walls)
	{
		int total = rows * columns;
		char[][] grid = new char[rows][columns];
		for (char[] row : grid)
		{
			Arrays.fill(row, 'E');
		}

		LinkedList<int[]> list = new LinkedList<>();
		for (int[] guard : guards)
		{
			int row = guard[0];
			int col = guard[1];
			grid[row][col] = 'G';
			// 0-up, 1-down, 2-left, 3-right
			list.addLast(new int[]{row - 1, col, 0});
			list.addLast(new int[]{row + 1, col, 1});
			list.addLast(new int[]{row, col - 1, 2});
			list.addLast(new int[]{row, col + 1, 3});
			total--;
		}

		for (int[] wall : walls)
		{
			grid[wall[0]][wall[1]] = 'W';
			total--;
		}

		while (!list.isEmpty())
		{
			int[] pos = list.removeFirst();
			int row = pos[0];
			int col = pos[1];
			int dir = pos[2];
			if (row < 0 || row == rows || col < 0 || col == columns)
			{
				continue;
			}

			if (grid[row][col] == 'G' || grid[row][col] == 'W')
			{
				continue;
			}

			if (grid[row][col] == 'E')
			{
				grid[row][col] = 'V';
				total--;
			}

			// 0-up, 1-down, 2-left, 3-right
			if (dir == 0)
			{
				list.addLast(new int[]{row - 1, col, dir});
			}
			else if (dir == 1)
			{
				list.addLast(new int[]{row + 1, col, dir});
			}
			else if (dir == 2)
			{
				list.addLast(new int[]{row, col - 1, dir});
			}
			else
			{
				list.addLast(new int[]{row, col + 1, dir});
			}
		}

		return total;
	}
}
