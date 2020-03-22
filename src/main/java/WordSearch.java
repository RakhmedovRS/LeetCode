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
				if (exists(memo, visited, position, word.substring(1)))
				{
					return true;
				}
				visited.remove(position);
			}
		}

		return false;
	}

	private boolean exists(Map<Character, List<Map.Entry<Integer, Integer>>> memo,
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
				if (exists(memo, visited, position, word.substring(1)))
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
