package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(id = 125, name = "Valid Palindrome", url = "https://leetcode.com/problems/valid-palindrome/")
public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		if (s == null || s.length() < 2)
		{
			return true;
		}

		int left = 0;
		int right = s.length() - 1;
		while (left <= right)
		{
			while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left)))
			{
				left++;
			}

			if (left == s.length())
			{
				break;
			}

			while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
			{
				right--;
			}

			if (left >= right)
			{
				break;
			}

			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
			{
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidPalindrome().isPalindrome("AB"));
	}
}
