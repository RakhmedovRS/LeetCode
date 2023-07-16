package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/19/2022
 */
@LeetCode(
		id = 2207,
		name = "Maximize Number of Subsequences in a String",
		url = "https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeNumberOfSubsequencesInString
{
	public long maximumSubsequenceCount(String text, String pattern)
	{
		long count = 0;
		long[] memoA = new long[text.length()];
		long[] memoB = new long[text.length()];
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == pattern.charAt(0))
			{
				count++;
			}
			memoA[i] = count;
		}

		count = 0;
		for (int i = chars.length - 1; i >= 0; i--)
		{
			if (chars[i] == pattern.charAt(1))
			{
				count++;
			}
			memoB[i] = count;
		}

		long max = 0;
		long sum = 0;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == pattern.charAt(0))
			{
				sum += (i + 1 < chars.length ? memoB[i + 1] : 0) + 1;
			}
		}

		max = Math.max(max, sum);
		sum = 0;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == pattern.charAt(1))
			{
				sum += (i - 1 >= 0 ? memoA[i - 1] : 0) + 1;
			}
		}

		max = Math.max(max, sum);

		return max;
	}
}
