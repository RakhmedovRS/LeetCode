package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Jul-20
 */
@LeetCode(
		id = 1332,
		name = "Remove Palindromic Subsequences",
		url = "https://leetcode.com/problems/remove-palindromic-subsequences/",
		difficulty = Difficulty.EASY
)
public class RemovePalindromicSubsequences
{
	public int removePalindromeSub(String s)
	{
		if (s.isEmpty())
		{
			return 0;
		}

		if (s.equals(new StringBuilder(s).reverse().toString()))
		{
			return 1;
		}

		return 2;
	}
}
