package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
		id = 1958,
		name = "Check if Move is Legal",
		url = "https://leetcode.com/problems/check-if-move-is-legal/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfMoveIsLegal
{
	public boolean checkMove(char[][] board, int row, int column, char color)
	{
		if (board[row][column] != '.')
		{
			return false;
		}

		board[row][column] = color;
		//left
		boolean seenOppositeColor = false;
		for (int c = column - 1; c >= 0 && board[row][c] != '.'; c--)
		{
			if (board[row][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//right
		seenOppositeColor = false;
		for (int c = column + 1; c < board[row].length && board[row][c] != '.'; c++)
		{
			if (board[row][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//up
		seenOppositeColor = false;
		for (int r = row - 1; r >= 0 && board[r][column] != '.'; r--)
		{
			if (board[r][column] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//down
		seenOppositeColor = false;
		for (int r = row + 1; r < board.length && board[r][column] != '.'; r++)
		{
			if (board[r][column] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//up left
		seenOppositeColor = false;
		for (int r = row - 1, c = column - 1; r >= 0 && c >= 0 && board[r][c] != '.'; r--, c--)
		{
			if (board[r][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//up right
		seenOppositeColor = false;
		for (int r = row - 1, c = column + 1; r >= 0 && c < board[row].length && board[r][c] != '.'; r--, c++)
		{
			if (board[r][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//down left
		seenOppositeColor = false;
		for (int r = row + 1, c = column - 1; r < board.length && c >= 0 && board[r][c] != '.'; r++, c--)
		{
			if (board[r][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		//down right
		seenOppositeColor = false;
		for (int r = row + 1, c = column + 1; r < board.length && c < board[row].length && board[r][c] != '.'; r++, c++)
		{
			if (board[r][c] == color)
			{
				if (seenOppositeColor)
				{
					return true;
				}
				break;
			}
			else
			{
				seenOppositeColor = true;
			}
		}

		return false;
	}
}
