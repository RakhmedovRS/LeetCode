import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Feb-20
 */
@LeetCode(id = 52, name = "N-Queens II", url = "https://leetcode.com/problems/n-queens-ii/")
public class NQueensII
{
	public boolean validPlacement(boolean[][] board, int row, int column)
	{
		for (int i = 0; i < board.length; i++)
		{
			if (i != column && board[row][i])
			{
				return false;
			}
		}

		for (int i = 0; i < board.length; i++)
		{
			if (i != row && board[i][column])
			{
				return false;
			}
		}

		for (int i = row + 1, j = column + 1; i < board.length && j < board.length; i++, j++)
		{
			if (board[i][j])
			{
				return false;
			}
		}

		for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j])
			{
				return false;
			}
		}

		for (int i = row - 1, j = column + 1; i >= 0 && j < board.length; i--, j++)
		{
			if (board[i][j])
			{
				return false;
			}
		}

		for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--)
		{
			if (board[i][j])
			{
				return false;
			}
		}

		return true;
	}

	public int totalNQueens(int n)
	{
		boolean[][] board = new boolean[n][n];
		int[] result = new int[1];
		nQueens(board, result, 0);
		return result[0];
	}

	public void nQueens(boolean[][] board, int[] result, int row)
	{
		if (row == board.length)
		{
			return;
		}

		for (int i = 0; i < board.length; i++)
		{
			board[row][i] = true;
			if (validPlacement(board, row, i))
			{
				nQueens(board, result, row + 1);
				if (row + 1 == board.length)
				{
					result[0]++;
				}
			}
			board[row][i] = false;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new NQueensII().totalNQueens(5));
	}
}
