package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(
		id = 115,
		name = "Distinct Subsequences",
		url = "https://leetcode.com/problems/distinct-subsequences/",
		difficulty = Difficulty.HARD
)
public class DistinctSubsequences
{
	public int numDistinct(String s, String t)
	{
		int[][] memo = new int[s.length()][t.length()];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return traverse(s.toCharArray(), 0, t.toCharArray(), 0, memo);
	}

	private int traverse(char[] word, int wordPos, char[] pattern, int patternPos, int[][] memo)
	{

		if (patternPos == pattern.length)
		{
			return 1;
		}

		if (wordPos == word.length)
		{
			return 0;
		}

		if (memo[wordPos][patternPos] != -1)
		{
			return memo[wordPos][patternPos];
		}

		int count = 0;
		if (word[wordPos] == pattern[patternPos])
		{
			count += traverse(word, wordPos + 1, pattern, patternPos + 1, memo);
		}
		count += traverse(word, wordPos + 1, pattern, patternPos, memo);

		memo[wordPos][patternPos] = count;

		return count;
	}
}
