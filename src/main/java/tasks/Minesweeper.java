package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/5/2020
 */
@LeetCode(
		id = 529,
		name = "Minesweeper",
		url = "https://leetcode.com/problems/minesweeper/",
		difficulty = Difficulty.MEDIUM
)
public class Minesweeper
{
	public char[][] updateBoard(char[][] board, int[] click)
	{
		if (board == null || board.length == 0 || click == null || click.length == 0)
		{
			return board;
		}

		int rows = board.length;
		int columns = board[0].length;
		int row = click[0];
		int column = click[1];

		if (board[row][column] == 'M')
		{
			board[row][column] = 'X';
			return board;
		}
		else if (Character.isDigit(board[row][column]))
		{
			return board;
		}

		int aCount = countAdjacentMines(board, row, column, rows, columns);
		if (aCount == 0)
		{
			dfs(board, row, column, rows, columns);
		}
		else
		{
			board[row][column] = (char) (aCount + '0');
		}

		return board;
	}

	private void dfs(char[][] board, int row, int column, int rows, int columns)
	{
		if (row < 0
			|| row == rows
			|| column < 0
			|| column == columns
			|| board[row][column] == 'X'
			|| board[row][column] == 'B'
			|| Character.isDigit(board[row][column])
		)
		{
			return;
		}

		if (board[row][column] == 'E')
		{
			int count = countAdjacentMines(board, row, column, rows, columns);
			if (count == 0)
			{
				board[row][column] = 'B';
				dfs(board, row - 1, column, rows, columns);
				dfs(board, row + 1, column, rows, columns);
				dfs(board, row, column - 1, rows, columns);
				dfs(board, row, column + 1, rows, columns);

				dfs(board, row - 1, column - 1, rows, columns);
				dfs(board, row - 1, column + 1, rows, columns);
				dfs(board, row + 1, column - 1, rows, columns);
				dfs(board, row + 1, column + 1, rows, columns);
			}
			else
			{
				board[row][column] = (char) (count + '0');
			}
		}
	}

	private int countAdjacentMines(char[][] board, int row, int column, int rows, int columns)
	{
		int count = 0;
		int aRow;
		int aColumn;
		for (int r = -1; r < 2; r++)
		{
			for (int c = -1; c < 2; c++)
			{
				aRow = row + r;
				aColumn = column + c;
				if (aRow >= 0 && aRow < rows && aColumn >= 0 && aColumn < columns)
				{
					count += board[aRow][aColumn] == 'M' ? 1 : 0;
				}
			}
		}

		return count;
	}
}
