import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-Jul-20
 */
@LeetCode(id = 959, name = "Regions Cut By Slashes", url = "https://leetcode.com/problems/regions-cut-by-slashes/")
public class RegionsCutBySlashes
{
	public int regionsBySlashes(String[] grid)
	{
		int N = grid[0].length() * 4;
		char[][] regions = new char[N][N];
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length(); column++)
			{
				char ch = grid[row].charAt(column);
				if (ch == '/')
				{
					regions[row * 4][column * 4 + 3] = '1';
					regions[row * 4 + 1][column * 4 + 2] = '1';
					regions[row * 4 + 2][column * 4 + 1] = '1';
					regions[row * 4 + 3][column * 4] = '1';
				}
				else if (ch == '\\')
				{
					regions[row * 4][column * 4] = '1';
					regions[row * 4 + 1][column * 4 + 1] = '1';
					regions[row * 4 + 2][column * 4 + 2] = '1';
					regions[row * 4 + 3][column * 4 + 3] = '1';
				}
			}
		}

		int answer = 0;
		for (int row = 0; row < N; row++)
		{
			for (int column = 0; column < N; column++)
			{
				if (regions[row][column] == 0)
				{
					answer++;
					explore(regions, row, column, N);
				}
			}
		}

		return answer;
	}

	private void explore(char[][] regions, int row, int column, int N)
	{
		if (row < 0 || row == N || column < 0 || column == N || regions[row][column] != 0)
		{
			return;
		}

		regions[row][column] = 'X';
		explore(regions, row - 1, column, N);
		explore(regions, row + 1, column, N);
		explore(regions, row, column - 1, N);
		explore(regions, row, column + 1, N);
	}
}
