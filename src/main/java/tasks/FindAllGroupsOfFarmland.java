package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 9/4/2021
 */
@LeetCode(
	id = 1992,
	name = "Find All Groups of Farmland",
	url = "https://leetcode.com/problems/find-all-groups-of-farmland/",
	difficulty = Difficulty.MEDIUM
)
public class FindAllGroupsOfFarmland
{
	public int[][] findFarmland(int[][] land)
	{
		int rows = land.length;
		int columns = land[0].length;

		List<int[]> list = new ArrayList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (land[row][column] == 1)
				{
					int[] tmp = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
					dfs(row, column, rows, columns, land, tmp);
					list.add(tmp);
				}
			}
		}

		int[][] answer = new int[list.size()][];

		for (int i = 0; i < list.size(); i++)
		{
			answer[i] = list.get(i);
		}

		return answer;
	}

	private void dfs(int row, int column, int rows, int columns, int[][] land, int[] tmp)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || land[row][column] == 0)
		{
			return;
		}

		if (row < tmp[0])
		{
			tmp[0] = row;
			tmp[1] = column;
		}

		if (row == tmp[0])
		{
			tmp[1] = Math.min(tmp[1], column);
		}

		if (row > tmp[2])
		{
			tmp[2] = row;
			tmp[3] = column;
		}

		if (row == tmp[2])
		{
			tmp[3] = Math.max(tmp[3], column);
		}

		land[row][column] = 0;
		dfs(row + 1, column, rows, columns, land, tmp);
		dfs(row - 1, column, rows, columns, land, tmp);
		dfs(row, column + 1, rows, columns, land, tmp);
		dfs(row, column - 1, rows, columns, land, tmp);
	}
}
