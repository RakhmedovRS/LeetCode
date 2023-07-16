package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Sep-20
 */
@LeetCode(
		id = 680,
		name = "Valid Palindrome II",
		url = "https://leetcode.com/problems/valid-palindrome-ii/",
		difficulty = Difficulty.EASY
)
public class ValidPalindromeII
{
	public boolean validPalindrome(String s)
	{
		return dfs(s.toCharArray(), 0, s.length() - 1, true);
	}

	private boolean dfs(char[] chars, int left, int right, boolean canDeleteCharacter)
	{
		if (left >= right)
		{
			return true;
		}

		while (left < right)
		{
			if (chars[left] != chars[right])
			{
				if (!canDeleteCharacter)
				{
					return false;
				}
				return dfs(chars, left + 1, right, false) || dfs(chars, left, right - 1, false);
			}
			left++;
			right--;
		}

		return true;
	}
}
