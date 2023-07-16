package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Aug-20
 */
@LeetCode(
		id = 1328,
		name = "Break a Palindrome",
		url = "https://leetcode.com/problems/break-a-palindrome/",
		difficulty = Difficulty.MEDIUM
)
public class BreakPalindrome
{
	public String breakPalindrome(String palindrome)
	{
		if (palindrome.length() == 1)
		{
			return "";
		}

		char[] chars = palindrome.toCharArray();
		int ch = 0;
		boolean isPalindrome = true;
		while (isPalindrome)
		{
			int left = 0;
			int right = chars.length - 1;
			char newChar = ((char) (ch + 'a'));
			while (left < right)
			{
				if (newChar != chars[right])
				{
					isPalindrome = false;
					chars[left] = (char) Math.min(newChar, chars[right]);
					chars[right] = (char) Math.max(newChar, chars[right]);
					break;
				}
				left++;
				right--;
			}
			ch++;
		}

		return String.valueOf(chars);
	}
}
