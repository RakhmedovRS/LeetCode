package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 4/30/2021
 */
@LeetCode(
		id = 1842,
		name = "Next Palindrome Using Same Digits",
		url = "https://leetcode.com/problems/next-palindrome-using-same-digits/",
		difficulty = Difficulty.HARD,
		premium = true
)
public class NextPalindromeUsingSameDigits
{
	public String nextPalindrome(String num)
	{
		char[] chars = num.toCharArray();
		if (isMaximumPalindrome(chars))
		{
			return "";
		}

		char[] leftPart = new char[chars.length / 2];
		for (int i = 0; i < leftPart.length; i++)
		{
			leftPart[i] = chars[i];
		}

		nextPermutation(leftPart);

		if (num.length() % 2 == 0)
		{
			return String.valueOf(leftPart) + new StringBuilder(String.valueOf(leftPart)).reverse().toString();
		}
		else
		{
			return String.valueOf(leftPart) + num.charAt(num.length() / 2) + new StringBuilder(String.valueOf(leftPart)).reverse().toString();
		}
	}

	private void nextPermutation(char[] leftPart)
	{
		for (int i = leftPart.length - 1; i > 0; i--)
		{
			if (leftPart[i - 1] < leftPart[i])
			{
				int pos = i;
				for (int j = i; j < leftPart.length; j++)
				{
					if (leftPart[j] > leftPart[i - 1] && leftPart[j] < leftPart[pos])
					{
						pos = j;
					}
				}

				char temp = leftPart[i - 1];
				leftPart[i - 1] = leftPart[pos];
				leftPart[pos] = temp;

				Arrays.sort(leftPart, i, leftPart.length);
				return;
			}
		}
	}

	private boolean isMaximumPalindrome(char[] chars)
	{
		for (int i = 0; i < chars.length / 2 - 1; i++)
		{
			if (chars[i] < chars[i + 1])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		NextPalindromeUsingSameDigits clazz = new NextPalindromeUsingSameDigits();
		System.out.println(clazz.nextPalindrome("23143034132"));
		System.out.println(clazz.nextPalindrome("23143034132"));
		System.out.println(clazz.nextPalindrome("4809889084"));
		System.out.println(clazz.nextPalindrome("7181221817"));
		System.out.println(clazz.nextPalindrome("45544554"));
		System.out.println(clazz.nextPalindrome("1221"));
		System.out.println(clazz.nextPalindrome("321123"));
		System.out.println(clazz.nextPalindrome("321123"));
	}
}
