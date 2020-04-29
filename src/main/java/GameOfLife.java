import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Apr-20
 */
@LeetCode(id = 289, name = "Game of Life", url = "https://leetcode.com/problems/game-of-life/")
public class GameOfLife
{
	public void gameOfLife(int[][] board)
	{
		if (board == null || board.length == 0)
		{
			return;
		}

		int rows = board.length;
		int columns = board[0].length;
		int[][] copy = new int[rows][columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				copy[row][column] = board[row][column];
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				board[row][column] = isAlive(copy, row, column, rows, columns) ? 1 : 0;
			}
		}
	}

	private boolean isAlive(int[][] board, int row, int column, int rows, int columns)
	{
		int neighbors = 0;

		neighbors += (row - 1 >= 0 && column - 1 >= 0) ? board[row - 1][column - 1] : 0;
		neighbors += (row - 1 >= 0) ? board[row - 1][column] : 0;
		neighbors += (row - 1 >= 0 && column + 1 < columns) ? board[row - 1][column + 1] : 0;
		neighbors += (column + 1 < columns) ? board[row][column + 1] : 0;
		neighbors += (row + 1 < rows && column + 1 < columns) ? board[row + 1][column + 1] : 0;
		neighbors += (row + 1 < rows) ? board[row + 1][column] : 0;
		neighbors += (row + 1 < rows && column - 1 >= 0) ? board[row + 1][column - 1] : 0;
		neighbors += (column - 1 >= 0) ? board[row][column - 1] : 0;

		if (board[row][column] == 1)
		{
			return neighbors >= 2 && neighbors <= 3;
		}
		else
		{
			return neighbors == 3;
		}
	}
}
