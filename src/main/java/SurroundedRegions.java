import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(id = 130, name = "Surrounded Regions", url = "https://leetcode.com/problems/surrounded-regions/")
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
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (row == 0 || row == rows - 1 || column == 0 || column == columns - 1)
				{
					dfs(board, row, column, rows, columns);
				}
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (board[row][column] == 'V')
				{
					board[row][column] = 'O';
				}
				else
				{
					board[row][column] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, int row, int column, int rows, int columns)
	{
		if (row < 0
			|| row == rows
			|| column < 0
			|| column == columns
			|| board[row][column] == 'V'
			|| board[row][column] == 'X')
		{
			return;
		}

		board[row][column] = 'V';

		dfs(board, row - 1, column, rows, columns);
		dfs(board, row + 1, column, rows, columns);
		dfs(board, row, column - 1, rows, columns);
		dfs(board, row, column + 1, rows, columns);
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
