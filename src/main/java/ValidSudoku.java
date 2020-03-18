import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 18-Mar-20
 */
@LeetCode(id = 36, name = "Valid Sudoku", url = "https://leetcode.com/problems/valid-sudoku/")
public class ValidSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		Set<Integer> set;
		for (int row = 0; row < board.length; row++)
		{
			set = new HashSet<>();
			for (int column = 0; column < board.length; column++)
			{
				char ch = board[row][column];
				if (ch != '.' && !set.add(ch - '1'))
				{
					return false;
				}

				if (row % 3 == 1 && column % 3 == 1 && !isValidArea(board, row, column))
				{
					return false;
				}
			}
		}

		for (int column = 0; column < board.length; column++)
		{
			set = new HashSet<>();
			for (char[] chars : board)
			{
				if (chars[column] != '.' && !set.add(chars[column] - '1'))
				{
					return false;
				}
			}
		}

		return true;
	}

	private boolean isValidArea(char[][] board, int row, int column)
	{
		Set<Character> set = new HashSet<>();
		for (int i = row - 1; i <= row + 1; i++)
		{
			for (int j = column - 1; j <= column + 1; j++)
			{
				if (board[i][j] != '.' && !set.add(board[i][j]))
				{
					return false;
				}
			}
		}

		return true;
	}
}
