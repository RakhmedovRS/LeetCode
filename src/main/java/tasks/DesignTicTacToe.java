package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Jan-21
 */
@LeetCode(
		id = 348,
		name = "Design Tic-Tac-Toe",
		url = "https://leetcode.com/problems/design-tic-tac-toe/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignTicTacToe
{
	class TicTacToe
	{

		/**
		 * Initialize your data structure here.
		 */
		Boolean[][] grid;

		public TicTacToe(int n)
		{
			grid = new Boolean[n][n];
		}

		/**
		 * Player {player} makes a move at ({row}, {col}).
		 *
		 * @param row    The row of the board.
		 * @param col    The column of the board.
		 * @param player The player, can be either 1 or 2.
		 * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2: Player 2 wins.
		 */
		public int move(int row, int col, int player)
		{
			grid[row][col] = player % 2 == 0;
			if (win(row, col, player))
			{
				return player;
			}

			return 0;
		}

		private boolean win(int row, int col, int player)
		{
			int count = 0;
			for (Boolean b : grid[row])
			{
				if (b == grid[row][col])
				{
					count++;
				}
			}

			if (count == grid.length)
			{
				return true;
			}

			count = 0;
			for (int r = 0; r < grid.length; r++)
			{
				if (grid[r][col] == grid[row][col])
				{
					count++;
				}
			}
			if (count == grid.length)
			{
				return true;
			}

			count = 0;
			for (int r = row, c = col; r >= 0 && c >= 0; r--, c--)
			{
				if (grid[r][c] == grid[row][col])
				{
					count++;
				}
			}
			for (int r = row + 1, c = col + 1; r < grid.length && c < grid.length; r++, c++)
			{
				if (grid[r][c] == grid[row][col])
				{
					count++;
				}
			}

			if (count == grid.length)
			{
				return true;
			}

			count = 0;
			for (int r = row, c = col; r >= 0 && c < grid.length; r--, c++)
			{
				if (grid[r][c] == grid[row][col])
				{
					count++;
				}
			}
			for (int r = row + 1, c = col - 1; r < grid.length && c >= 0; r++, c--)
			{
				if (grid[r][c] == grid[row][col])
				{
					count++;
				}
			}

			return count == grid.length;
		}
	}

	public static void main(String[] args)
	{
		TicTacToe ticTacToe = new DesignTicTacToe().new TicTacToe(3);
		ticTacToe.move(0, 0, 1);
		ticTacToe.move(0, 2, 2);
		ticTacToe.move(2, 2, 1);
		ticTacToe.move(1, 1, 2);
		ticTacToe.move(2, 0, 1);
		ticTacToe.move(1, 0, 2);
		ticTacToe.move(2, 1, 1);
	}
}
