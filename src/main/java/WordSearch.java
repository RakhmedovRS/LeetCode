import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Mar-20
 */
@LeetCode(id = 79, name = "Word Search", url = "https://leetcode.com/problems/word-search/")
public class WordSearch
{
	public boolean exist(char[][] board, String word)
	{
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			{
				if (exist(board, row, column, word, 0))
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int row, int column, String word, int start)
	{
		if (start >= word.length())
		{
			return true;
		}
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
		{
			return false;
		}

		if (board[row][column] == word.charAt(start++))
		{
			char c = board[row][column];
			board[row][column] = '#';
			boolean res = exist(board, row + 1, column, word, start)
				|| exist(board, row - 1, column, word, start)
				|| exist(board, row, column + 1, word, start)
				|| exist(board, row, column - 1, word, start);
			board[row][column] = c;
			return res;
		}
		return false;
	}

	public boolean exist1(char[][] board, String word)
	{
		Map<Character, List<Map.Entry<Integer, Integer>>> memo = new HashMap<>();
		for (int row = 0; row < board.length; row++)
		{
			for (int column = 0; column < board[row].length; column++)
			{
				char currentChar = board[row][column];
				List<Map.Entry<Integer, Integer>> list = memo.getOrDefault(currentChar, new ArrayList<>());
				list.add(new java.util.AbstractMap.SimpleEntry<>(row, column));
				memo.put(currentChar, list);
			}
		}

		for (char ch : word.toCharArray())
		{
			if (!memo.containsKey(ch))
			{
				return false;
			}
		}

		char ch = word.charAt(0);
		Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
		for (Map.Entry<Integer, Integer> position : memo.get(ch))
		{
			if (visited.add(position))
			{
				if (exists1(memo, visited, position, word.substring(1)))
				{
					return true;
				}
				visited.remove(position);
			}
		}

		return false;
	}

	private boolean exists1(Map<Character, List<Map.Entry<Integer, Integer>>> memo,
	                        Set<Map.Entry<Integer, Integer>> visited,
	                        Map.Entry<Integer, Integer> prevPosition,
	                        String word)
	{
		if ("".equals(word))
		{
			return true;
		}

		char ch = word.charAt(0);
		for (Map.Entry<Integer, Integer> position : memo.get(ch))
		{
			if (isAdjacent(prevPosition, position) && visited.add(position))
			{
				if (exists1(memo, visited, position, word.substring(1)))
				{
					return true;
				}
				visited.remove(position);
			}
		}

		return false;
	}

	private boolean isAdjacent(Map.Entry<Integer, Integer> prevPosition,
	                           Map.Entry<Integer, Integer> currPosition)
	{
		return (Math.abs(prevPosition.getKey() - currPosition.getKey())
			+ Math.abs(prevPosition.getValue() - currPosition.getValue())) <= 1;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordSearch().exist1(
			new char[][]{
				{'A'},
			}, "AB"));

		System.out.println(new WordSearch().exist1(
			new char[][]{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
			}, "ABCCED"));

		System.out.println(new WordSearch().exist1(
			new char[][]{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
			}, "SEE"));

		System.out.println(new WordSearch().exist1(
			new char[][]{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
			}, "ABCB"));
	}
}
