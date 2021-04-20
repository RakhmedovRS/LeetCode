package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(id = 1312, name = "Minimum Insertion Steps to Make a String Palindrome", url = "https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/")
public class MinimumInsertionStepsToMakeStringPalindrome
{
	public int minInsertions(String s)
	{
		int[][] memo = new int[s.length()][s.length()];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return minInsertions(s, 0, s.length() - 1, memo);
	}

	private int minInsertions(String s, int start, int end, int[][] memo)
	{
		if (start > end)
		{
			return Integer.MAX_VALUE;
		}

		if (memo[start][end] != -1)
		{
			return memo[start][end];
		}

		if (start == end)
		{
			memo[start][end] = 0;
			return memo[start][end];
		}

		final boolean b = s.charAt(start) == s.charAt(end);
		if (start == end - 1)
		{
			memo[start][end] = b ? 0 : 1;
			return memo[start][end];
		}

		if (b)
		{
			memo[start][end] = minInsertions(s, start + 1, end - 1, memo);
		}
		else
		{
			memo[start][end] = Math.min(minInsertions(s, start + 1, end, memo), minInsertions(s, start, end - 1, memo)) + 1;
		}
		return memo[start][end];
	}
}
