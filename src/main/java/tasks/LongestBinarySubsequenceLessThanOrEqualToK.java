package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/20/2022
 */
@LeetCode(
	id = 2311,
	name = "Longest Binary Subsequence Less Than or Equal to K",
	url = "https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/",
	difficulty = Difficulty.MEDIUM
)
public class LongestBinarySubsequenceLessThanOrEqualToK
{
	public int longestSubsequence(String s, int k)
	{
		boolean[] bits = new boolean[s.length()];
		int zeroes = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '1')
			{
				bits[i] = true;
			}
			else
			{
				zeroes++;
			}
		}

		int res = zeroes;
		long num = 0;
		for (int i = bits.length - 1, j = 0; i >= 0; i--, j++)
		{
			if (bits[i])
			{
				if (num + (1L << j) > k)
				{
					break;
				}
				else
				{
					num += (1L << j);
					res++;
				}
			}
		}

		return res;
	}
}
