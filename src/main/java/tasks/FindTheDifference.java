package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/24/2020
 */
@LeetCode(
	id = 389,
	name = "Find the Difference",
	url = "https://leetcode.com/problems/find-the-difference/",
	difficulty = Difficulty.EASY
)
public class FindTheDifference
{
	public char findTheDifference(String s, String t)
	{
		char[] memo = new char[26];
		for (int i = 0; i < s.length(); i++)
		{
			memo[s.charAt(i) - 'a']--;
		}

		for (int i = 0; i < t.length(); i++)
		{
			memo[t.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] == 1)
			{
				return (char) (i + 'a');
			}
		}
		return ' ';
	}
}
