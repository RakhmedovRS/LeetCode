package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/12/2021
 */
@LeetCode(
	id = 723,
	name = "Candy Crush",
	url = "https://leetcode.com/problems/candy-crush/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class CandyCrush
{
	public int[][] candyCrush(int[][] board)
	{
		int rows = board.length;
		int columns = board[0].length;
		boolean canRemove = true;
		boolean[][] memo;
		while (canRemove)
		{
			canRemove = false;
			memo = new boolean[rows][columns];
			for (int row = 0; row < rows; row++)
			{
				for (int column = 0; column < columns; column++)
				{
					if (board[row][column] != 0 && canRemove(row, column, rows, columns, board))
					{
						canRemove = true;
						memo[row][column] = true;
					}
				}
			}

			if (canRemove)
			{
				erase(memo, board);
			}
		}
		return board;
	}

	private boolean canRemove(int row, int column, int rows, int columns, int[][] board)
	{
		if (column - 2 >= 0 && board[row][column - 2] == board[row][column - 1] && board[row][column - 1] == board[row][column])
		{
			return true;
		}

		if (column - 1 >= 0 && column + 1 < columns && board[row][column - 1] == board[row][column] && board[row][column] == board[row][column + 1])
		{
			return true;
		}

		if (column + 2 < columns && board[row][column] == board[row][column + 1] && board[row][column + 1] == board[row][column + 2])
		{
			return true;
		}

		if (row - 2 >= 0 && board[row - 2][column] == board[row - 1][column] && board[row - 1][column] == board[row][column])
		{
			return true;
		}

		if (row - 1 >= 0 && row + 1 < rows && board[row - 1][column] == board[row][column] && board[row][column] == board[row + 1][column])
		{
			return true;
		}

		if (row + 2 < rows && board[row][column] == board[row + 1][column] && board[row + 1][column] == board[row + 2][column])
		{
			return true;
		}

		return false;
	}

	private void erase(boolean[][] memo, int[][] board)
	{
		for (int row = 0; row < memo.length; row++)
		{
			for (int column = 0; column < memo[row].length; column++)
			{
				if (memo[row][column])
				{
					int uRow = row - 1;
					int dRow = row;
					while (dRow < memo.length && memo[dRow][column])
					{
						memo[dRow][column] = false;
						dRow++;
					}

					dRow--;

					while (dRow >= 0)
					{
						board[dRow--][column] = uRow < 0 ? 0 : board[uRow--][column];
					}
				}
			}
		}
	}
}
