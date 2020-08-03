import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(id = 125, name = "Valid Palindrome", url = "https://leetcode.com/problems/valid-palindrome/")
public class ValidPalindrome
{
	public boolean isPalindrome(String s)
	{
		int left = 0;
		int right = s.length() - 1;
		while (left < right)
		{
			while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left)))
			{
				left++;
			}

			while (right > left && !Character.isLetterOrDigit(s.charAt(right)))
			{
				right--;
			}

			if (left < right && Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)))
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidPalindrome().isPalindrome("AB"));
	}
}
