package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/11/2020
 */
@LeetCode(id = 1616, name = "Split Two Strings to Make Palindrome", url = "https://leetcode.com/problems/split-two-strings-to-make-palindrome/")
public class SplitTwoStringsToMakePalindrome
{
	public boolean checkPalindromeFormation(String a, String b)
	{
		char[] charsA = a.toCharArray();
		char[] charsB = b.toCharArray();

		if (isPalindrome(charsA, 0, a.length() - 1) || isPalindrome(charsB, 0, b.length() - 1))
		{
			return true;
		}

		int charsALeft = 0;
		int charARight = charsA.length - 1;
		int charsBLeft = 0;
		int charBRight = charsB.length - 1;

		for (int i = 0; i < charsA.length / 2; i++)
		{
			if (charsA[charsALeft] == charsB[charBRight])
			{
				charsALeft++;
				charBRight--;
			}

			if (charsB[charsBLeft] == charsA[charARight])
			{
				charsBLeft++;
				charARight--;
			}
		}

		return isPalindrome(charsA, charsALeft, charBRight)
			|| isPalindrome(charsB, charsALeft, charBRight)
			|| isPalindrome(charsA, charsBLeft, charARight)
			|| isPalindrome(charsB, charsBLeft, charARight);
	}

	private boolean isPalindrome(char[] chars, int left, int right)
	{
		while (left < right)
		{
			if (chars[left++] != chars[right--])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation(
			"aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",
			"uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));

		System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation(
			"pvhmupgqeltozftlmfjjde",
			"yjgpzbezspnnpszebzmhvp"));

		System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation("ulacfd", "jizalu"));
		System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation("abdef", "fecab"));
	}
}
