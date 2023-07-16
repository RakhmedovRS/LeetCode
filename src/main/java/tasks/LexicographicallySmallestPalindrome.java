package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/20/2023
 */
@LeetCode(
		id = 2697,
		name = "Lexicographically Smallest Palindrome",
		url = "https://leetcode.com/problems/lexicographically-smallest-palindrome/",
		difficulty = Difficulty.EASY
)
public class LexicographicallySmallestPalindrome
{
	public String makeSmallestPalindrome(String s)
	{
		char[] chars = s.toCharArray();
		for (int left = 0, right = chars.length - 1; left < right; left++, right--)
		{
			if (chars[left] != chars[right])
			{
				if (chars[left] <= chars[right])
				{
					chars[right] = chars[left];
				}
				else
				{
					chars[left] = chars[right];
				}
			}
		}

		return new String(chars);
	}
}
