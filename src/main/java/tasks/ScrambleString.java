package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(id = 87, name = "Scramble String", url = "https://leetcode.com/problems/scramble-string/")
public class ScrambleString
{
	public boolean isScramble(String s1, String s2)
	{
		if (s1.equals(s2))
		{
			return true;
		}

		if (!containTheSameChars(s1, s2))
		{
			return false;
		}

		for (int i = 1; i < s1.length(); i++)
		{
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
				isScramble(s1.substring(i), s2.substring(i)))
			{
				return true;
			}

			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
				&& isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
			{
				return true;
			}
		}

		return false;
	}

	private boolean containTheSameChars(String s1, String s2)
	{
		int[] s1Chars = new int[26];
		int[] s2Chars = new int[26];
		for (char ch : s1.toCharArray())
		{
			s1Chars[ch - 'a']++;
		}

		for (char ch : s2.toCharArray())
		{
			s2Chars[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (s1Chars[i] != s2Chars[i])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new ScrambleString().isScramble("great", "rgeat"));
	}
}
