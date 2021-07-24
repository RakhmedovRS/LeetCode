package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/24/2021
 */
@LeetCode(
	id = 1941,
	name = "Check if All Characters Have Equal Number of Occurrences",
	url = "https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/",
	difficulty = Difficulty.EASY
)
public class CheckIfAllCharactersHaveEqualNumberOfOccurrences
{
	public boolean areOccurrencesEqual(String s)
	{
		int[] memo = new int[26];
		for (char ch : s.toCharArray())
		{
			memo[ch - 'a']++;
		}

		int max = 0;
		for (int count : memo)
		{
			if (count != 0)
			{
				if (max == 0)
				{
					max = count;
				}

				if (max != count)
				{
					return false;
				}
			}
		}

		return true;
	}
}
