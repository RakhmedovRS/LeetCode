package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(
	id = 130,
	name = "Surrounded Regions",
	url = "https://leetcode.com/problems/surrounded-regions/",
	difficulty = Difficulty.MEDIUM
)
public class SurroundedRegions
{
	public void solve(char[][] board)
	{
		if (board == null || board.length == 0)
		{
			return;
		}

		int rows = board.length;
		int columns = board[0].length;

		for (int column = 0; column < columns; column++)
		{
			if (board[0][column] == 'O')
			{
				fill(board, 0, column, rows, columns);
			}

			if (board[rows - 1][column] == 'O')
			{
				fill(board, rows - 1, column, rows, columns);
			}
		}

		for (int row = 0; row < rows; row++)
		{
			if (board[row][0] == 'O')
			{
				fill(board, row, 0, rows, columns);
			}

			if (board[row][columns - 1] == 'O')
			{
				fill(board, row, columns - 1, rows, columns);
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				board[row][column] = board[row][column] == 'Z' ? 'O' : 'X';
			}
		}

	}

	private void fill(char[][] board, int row, int column, int rows, int columns)
	{
		if (row < 0
			|| row == rows
			|| column < 0
			|| column == columns
			|| board[row][column] == 'X'
			|| board[row][column] == 'Z'
		)
		{
			return;
		}

		board[row][column] = 'Z';

		fill(board, row - 1, column, rows, columns);
		fill(board, row + 1, column, rows, columns);
		fill(board, row, column - 1, rows, columns);
		fill(board, row, column + 1, rows, columns);
	}

	public static void main(String[] args)
	{
		char[][] board0 = new char[][]
			{
				{'O', 'X', 'O', 'O', 'O', 'X'},
				{'O', 'O', 'X', 'X', 'X', 'O'},
				{'X', 'X', 'X', 'X', 'X', 'O'},
				{'O', 'O', 'O', 'O', 'X', 'X'},
				{'X', 'X', 'O', 'O', 'X', 'O'},
				{'O', 'O', 'X', 'X', 'X', 'X'}};

		new SurroundedRegions().solve(board0);
		for (char[] row : board0)
		{
			System.out.println(Arrays.toString(row));
		}

		System.out.println();

		char[][] board1 = new char[][]
			{
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}
			};

		new SurroundedRegions().solve(board1);
		for (char[] row : board1)
		{
			System.out.println(Arrays.toString(row));
		}
	}
}
