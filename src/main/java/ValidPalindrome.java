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
		if (s == null || s.length() == 0)
		{
			return true;
		}

		List<Character> characters = new ArrayList<>();
		for (char ch : s.toCharArray())
		{
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
			{

				characters.add((ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch);
			}
		}

		for (int left = 0, right = characters.size() - 1; left < right; left++, right--)
		{
			if (characters.get(left) != characters.get(right))
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
