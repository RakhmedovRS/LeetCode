package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Apr-20
 */
@LeetCode(
	id = 289,
	name = "Game of Life",
	url = "https://leetcode.com/problems/game-of-life/",
	difficulty = Difficulty.MEDIUM
)
public class GameOfLife
{
	public void gameOfLife(int[][] board)
	{
		int rows = board.length;
		if (rows == 0)
		{
			return;
		}
		int columns = board[0].length;

		boolean result;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				result = survivedOrNewCell(row, column, rows, columns, board);
				if (board[row][column] == 1)
				{
					board[row][column] = result ? 1 : -1;
				}
				else if (board[row][column] == 0)
				{
					board[row][column] = result ? 2 : 0;
				}
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (board[row][column] > 0)
				{
					board[row][column] = 1;
				}
				else
				{
					board[row][column] = 0;
				}
			}
		}
	}

	private boolean survivedOrNewCell(int row, int column, int rows, int columns, int[][] board)
	{
		int neighbors = 0;
		for (int r = -1; r <= 1; r++)
		{
			for (int c = -1; c <= 1; c++)
			{
				if (r + row == row && c + column == column)
				{
					continue;
				}

				if (r + row < 0 || r + row == rows || c + column < 0 || c + column == columns)
				{
					continue;
				}

				neighbors += Math.abs(board[r + row][c + column]) == 1 ? 1 : 0;
			}
		}

		if (board[row][column] == 1)
		{
			return neighbors == 2 || neighbors == 3;
		}
		else
		{
			return neighbors == 3;
		}
	}
}
