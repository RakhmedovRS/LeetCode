package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Feb-20
 */
@LeetCode(
		id = 52,
		name = "N-Queens II",
		url = "https://leetcode.com/problems/n-queens-ii/",
		difficulty = Difficulty.HARD
)
public class NQueensII
{
	public int totalNQueens(int n)
	{
		boolean[][] board = new boolean[n][n];
		int[] answer = new int[1];
		dfs(0, board, answer);

		return answer[0];
	}

	private void dfs(int row, boolean[][] board, int[] answer)
	{
		if (row == board.length)
		{
			answer[0]++;
			return;
		}

		for (int column = 0; column < board[row].length; column++)
		{
			if (canPlaceQueen(row, column, board))
			{
				board[row][column] = true;
				dfs(row + 1, board, answer);
				board[row][column] = false;
			}
		}
	}

	private boolean canPlaceQueen(int row, int column, boolean[][] table)
	{
		//horizontal line
		for (int c = 0; c < table[row].length; c++)
		{
			if (table[row][c])
			{
				return false;
			}
		}

		//vertical line
		for (int r = 0; r < table.length; r++)
		{
			if (table[r][column])
			{
				return false;
			}
		}

		//slash line
		for (int r = row, c = column; r < table.length && c >= 0; r++, c--)
		{
			if (table[r][c])
			{
				return false;
			}
		}
		for (int r = row, c = column; r >= 0 && c < table[row].length; r--, c++)
		{
			if (table[r][c])
			{
				return false;
			}
		}

		//backslash line
		for (int r = row, c = column; r >= 0 && c >= 0; r--, c--)
		{
			if (table[r][c])
			{
				return false;
			}
		}
		for (int r = row, c = column; r < table.length && c < table[row].length; r++, c++)
		{
			if (table[r][c])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new NQueensII().totalNQueens(5));
	}
}
