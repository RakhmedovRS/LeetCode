package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-Mar-20
 */
@LeetCode(
	id = 36,
	name = "Valid Sudoku",
	url = "https://leetcode.com/problems/valid-sudoku/",
	difficulty = Difficulty.MEDIUM
)
public class ValidSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		for (char[] row : board)
		{
			boolean[] seen = new boolean[10];
			for (int column = 0; column < board.length; column++)
			{
				if (row[column] != '.' && seen[row[column] - '0'])
				{
					return false;
				}

				if (row[column] != '.')
				{
					seen[row[column] - '0'] = true;
				}
			}
		}

		for (int column = 0; column < board[0].length; column++)
		{
			boolean[] seen = new boolean[10];
			for (char[] row : board)
			{
				if (row[column] != '.' && seen[row[column] - '0'])
				{
					return false;
				}

				if (row[column] != '.')
				{
					seen[row[column] - '0'] = true;
				}
			}
		}

		int[][] positions = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
		for (int[] position : positions)
		{
			boolean[] seen = new boolean[10];
			for (int row = position[0]; row < position[0] + 3; row++)
			{
				for (int column = position[1]; column < position[1] + 3; column++)
				{
					if (board[row][column] != '.' && seen[board[row][column] - '0'])
					{
						return false;
					}

					if (board[row][column] != '.')
					{
						seen[board[row][column] - '0'] = true;
					}
				}
			}
		}

		return true;
	}
}
