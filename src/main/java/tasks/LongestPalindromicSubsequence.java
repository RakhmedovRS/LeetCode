package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 27-Jul-20
 */
@LeetCode(id = 516, name = "Longest Palindromic Subsequence", url = "https://leetcode.com/problems/longest-palindromic-subsequence/")
public class LongestPalindromicSubsequence
{
	public int longestPalindromeSubseq(String s)
	{
		if (s.length() <= 1)
		{
			return s.length();
		}

		char[] chars = s.toCharArray();
		int[][] memo = new int[s.length()][s.length()];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return findLongest(chars, 0, chars.length - 1, memo);
	}

	private int findLongest(char[] chars, int left, int right, int[][] memo)
	{
		if (left == right)
		{
			return 1;
		}
		else if (left > right)
		{
			return 0;
		}

		if (memo[left][right] != -1)
		{
			return memo[left][right];
		}

		if (chars[left] == chars[right])
		{
			memo[left][right] = 2 + findLongest(chars, left + 1, right - 1, memo);
		}
		else
		{
			memo[left][right] = Math.max(findLongest(chars, left + 1, right, memo),
				findLongest(chars, left, right - 1, memo));
		}

		return memo[left][right];
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
		System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("abab"));
	}
}
