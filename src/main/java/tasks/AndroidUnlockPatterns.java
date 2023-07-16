package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/2/2021
 */
@LeetCode(
		id = 351,
		name = "Android Unlock Patterns",
		url = "https://leetcode.com/problems/android-unlock-patterns/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class AndroidUnlockPatterns
{
	public int numberOfPatterns(int m, int n)
	{
		boolean[][] board = new boolean[3][3];
		int[] count = new int[]{0};
		for (int row = 0; row < 3; row++)
		{
			for (int column = 0; column < 3; column++)
			{
				board[row][column] = true;
				dfs(board, row, column, m, n, 1, count);
				board[row][column] = false;
			}
		}
		return count[0];
	}

	private void dfs(boolean[][] board, int row, int column, int m, int n, int used, int[] count)
	{
		if (used >= m && used <= n)
		{
			count[0]++;
		}

		if (used >= n || used == 9)
		{
			return;
		}

		for (int cRow = 0; cRow < 3; cRow++)
		{
			for (int cColumn = 0; cColumn < 3; cColumn++)
			{
				if (eligible(board, row, column, cRow, cColumn))
				{
					board[cRow][cColumn] = true;
					dfs(board, cRow, cColumn, m, n, used + 1, count);
					board[cRow][cColumn] = false;
				}
			}
		}
	}

	private boolean eligible(boolean[][] screen, int i, int j, int i2, int j2)
	{
		// has been visited
		if (screen[i2][j2])
		{
			return false;
		}

		int xDiff = Math.abs(i - i2);
		int yDiff = Math.abs(j - j2);

		// surrounding
		if (xDiff <= 1 && yDiff <= 1)
		{
			return true;
		}

		//  controversy case (1 - 8, 2 - 9 ...)
		if (xDiff == 2 && yDiff == 1 || yDiff == 2 && xDiff == 1)
		{
			return true;
		}

		// same row/col but with a key between them
		if (xDiff == 0 && yDiff == 2)
		{
			return screen[i][1];
		}
		if (xDiff == 2 && yDiff == 0)
		{
			return screen[1][j];
		}

		// opposite corner
		if (Math.abs(i - i2) + Math.abs(j - j2) == 4 && screen[1][1])
		{
			return true;
		}

		return false;
	}
}
