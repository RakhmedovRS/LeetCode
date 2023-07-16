package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/7/2022
 */
@LeetCode(
		id = 2396,
		name = "Strictly Palindromic Number",
		url = "https://leetcode.com/problems/strictly-palindromic-number/",
		difficulty = Difficulty.MEDIUM
)
public class StrictlyPalindromicNumber
{
	public boolean isStrictlyPalindromic(int n)
	{
		for (int i = 2; i <= n - 2; i++)
		{
			String value = Integer.toString(n, i);
			for (int left = 0, right = value.length() - 1; left <= right; left++, right--)
			{
				if (value.charAt(left) != value.charAt(right))
				{
					return false;
				}
			}
		}

		return true;
	}
}
