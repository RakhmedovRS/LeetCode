package tasks;

import common.Difficulty;
import common.LeetCode;


/**
 * @author RakhmedovRS
 * @created 9/26/2020
 */
@LeetCode(
		id = 859,
		name = "Buddy Strings",
		url = "https://leetcode.com/problems/buddy-strings/",
		difficulty = Difficulty.EASY
)
public class BuddyStrings
{
	public boolean buddyStrings(String A, String B)
	{
		if (A.length() != B.length() || A.length() < 2)
		{
			return false;
		}

		char[] charsA = A.toCharArray();
		char[] charsB = B.toCharArray();
		int[] memo = new int[26];
		for (char ch : charsA)
		{
			memo[ch - 'a']++;
		}

		for (char ch : charsB)
		{
			memo[ch - 'a']--;
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] != 0)
			{
				return false;
			}
		}

		int mismatches = 0;
		memo = new int[26];
		for (int i = 0; i < charsA.length; i++)
		{
			if (charsA[i] != charsB[i])
			{
				mismatches++;
				memo[charsA[i] - 'a']++;
				memo[charsB[i] - 'a']--;
			}
		}

		if (mismatches == 0)
		{
			memo = new int[26];
			for (char ch : charsA)
			{
				if (++memo[ch - 'a'] == 2)
				{
					return true;
				}
			}
		}
		else if (mismatches != 2)
		{
			return false;
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] != 0)
			{
				return false;
			}
		}


		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new BuddyStrings().buddyStrings("acccccb", "bccccca"));
		System.out.println(new BuddyStrings().buddyStrings("abcaa", "abcbb"));
		System.out.println(new BuddyStrings().buddyStrings("ab", "ab"));
		System.out.println(new BuddyStrings().buddyStrings("aa", "aa"));
		System.out.println(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
	}
}
