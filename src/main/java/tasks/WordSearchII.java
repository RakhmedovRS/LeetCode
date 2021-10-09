package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 26-Apr-20
 */
@LeetCode(
	id = 212,
	name = "Word Search II",
	url = "https://leetcode.com/problems/word-search-ii/",
	difficulty = Difficulty.HARD
)
public class WordSearchII
{
	public List<String> findWords(char[][] board, String[] words)
	{
		List<String> result = new ArrayList<>();
		if (board == null || board.length == 0 || words == null || words.length == 0)
		{
			return result;
		}

		int rows = board.length;
		int columns = board[0].length;
		Map<Character, List<int[]>> startPositions = new HashMap<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				List<int[]> points = startPositions.getOrDefault(board[row][column], new ArrayList<>());
				points.add(new int[]{row, column});
				startPositions.put(board[row][column], points);
			}
		}

		for (String word : words)
		{
			List<int[]> positions = startPositions.getOrDefault(word.charAt(0), Collections.emptyList());
			for (int[] position : positions)
			{
				if (dsf(board, position[0], position[1], word, 0))
				{
					result.add(word);
					break;
				}
			}
		}

		return result;
	}

	private boolean dsf(char[][] board, int row, int column, String word, int pos)
	{
		if (pos >= word.length())
		{
			return true;
		}

		if (row < 0 || row == board.length || column < 0 || column == board[0].length || word.charAt(pos) != board[row][column])
		{
			return false;
		}

		char temp = board[row][column];
		board[row][column] = ' ';
		pos++;
		boolean result = (dsf(board, row - 1, column, word, pos)
			|| dsf(board, row + 1, column, word, pos)
			|| dsf(board, row, column - 1, word, pos)
			|| dsf(board, row, column + 1, word, pos));
		board[row][column] = temp;
		return result;
	}

	public static void main(String[] args)
	{
		char[][] board = new char[][]
			{
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'},
			};
		String[] words = new String[]{"oath", "pea", "eat", "rain"};

		System.out.println(new WordSearchII().findWords(board, words));
	}
}
