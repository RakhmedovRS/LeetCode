import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 72, name = "Edit Distance", url = "https://leetcode.com/problems/edit-distance/")
public class EditDistance
{
	public int minDistance(String word1, String word2)
	{
		char[] firstWord = word1.toCharArray();
		char[] secondWord = word2.toCharArray();
		int rowsCount = firstWord.length + 1;
		int columnsCount = secondWord.length + 1;
		int[][] memo = new int[rowsCount][columnsCount];

		for (int row = 1; row < rowsCount; row++)
		{
			memo[row][0] = memo[row - 1][0] + 1;
		}

		for (int column = 1; column < columnsCount; column++)
		{
			memo[0][column] = memo[0][column - 1] + 1;
		}

		for (int row = 1; row < rowsCount; row++)
		{
			for (int column = 1; column < columnsCount; column++)
			{
				if (firstWord[row - 1] == secondWord[column - 1])
				{
					memo[row][column] = memo[row - 1][column - 1];
				}
				else
				{
					memo[row][column] = Math.min(memo[row][column - 1], Math.min(memo[row - 1][column - 1], memo[row - 1][column])) + 1;
				}
			}
		}

		return memo[rowsCount - 1][columnsCount - 1];
	}

	public int minDistance1(String word1, String word2)
	{
		int[][] memo = new int[word1.length()][word2.length()];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return levenshteinDistance(word1, word2, word1.length() - 1, word2.length() - 1, memo);
	}

	private int levenshteinDistance(String firstWord, String secondWord, int firstIndex, int secondIndex, int[][] memo)
	{
		if (firstIndex < 0)
		{
			return secondIndex + 1;
		}
		else if (secondIndex < 0)
		{
			return firstIndex + 1;
		}

		if (memo[firstIndex][secondIndex] != -1)
		{
			return memo[firstIndex][secondIndex];
		}

		if (firstWord.charAt(firstIndex) == secondWord.charAt(secondIndex))
		{
			memo[firstIndex][secondIndex] = levenshteinDistance(firstWord, secondWord, firstIndex - 1, secondIndex - 1, memo);
		}
		else
		{
			int delete = levenshteinDistance(firstWord, secondWord, firstIndex - 1, secondIndex, memo);
			int insert = levenshteinDistance(firstWord, secondWord, firstIndex, secondIndex - 1, memo);
			int replace = levenshteinDistance(firstWord, secondWord, firstIndex - 1, secondIndex - 1, memo);

			memo[firstIndex][secondIndex] = Math.min(delete, Math.min(insert, replace)) + 1;
		}

		return memo[firstIndex][secondIndex];
	}

	public static void main(String[] args)
	{
		System.out.println(new EditDistance().minDistance("", "a"));
		System.out.println(new EditDistance().minDistance("horse", "ros"));
		System.out.println(new EditDistance().minDistance("abba", "abba"));

		System.out.println(new EditDistance().minDistance1("", "a"));
		System.out.println(new EditDistance().minDistance1("horse", "ros"));
		System.out.println(new EditDistance().minDistance1("abba", "abba"));
	}
}
