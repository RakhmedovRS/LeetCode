package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Mar-20
 */
@LeetCode(
		id = 79,
		name = "Word Search",
		url = "https://leetcode.com/problems/word-search/",
		difficulty = Difficulty.MEDIUM
)
public class WordSearch
{
	public boolean exist(char[][] board, String word)
	{
		if (board == null || board.length == 0 || word == null || word.length() == 0)
		{
			return false;
		}

		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			{
				if (exist(board, word, row, column, 0))
				{
					return true;
				}
			}
		}

		return false;
	}

	public boolean exist(char[][] board, String word, int row, int column, int idx)
	{
		if (idx == word.length())
		{
			return true;
		}

		if (row < 0 || row >= board.length || column < 0 || column >= board[row].length)
		{
			return false;
		}

		if (board[row][column] == word.charAt(idx))
		{
			char temp = board[row][column];
			board[row][column] = ' ';
			if (exist(board, word, row - 1, column, idx + 1)
					|| exist(board, word, row + 1, column, idx + 1)
					|| exist(board, word, row, column - 1, idx + 1)
					|| exist(board, word, row, column + 1, idx + 1))
			{
				return true;
			}
			board[row][column] = temp;
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordSearch().exist(
				new char[][]{
						{'A'},
				}, "AB"));

		System.out.println(new WordSearch().exist(
				new char[][]{
						{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}
				}, "ABCCED"));

		System.out.println(new WordSearch().exist(
				new char[][]{
						{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}
				}, "SEE"));

		System.out.println(new WordSearch().exist(
				new char[][]{
						{'A', 'B', 'C', 'E'},
						{'S', 'F', 'C', 'S'},
						{'A', 'D', 'E', 'E'}
				}, "ABCB"));
	}
}
