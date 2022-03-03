package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/3/2022
 */
@LeetCode(
	id = 2186,
	name = "Minimum Number of Steps to Make Two Strings Anagram II",
	url = "https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfStepsToMakeTwoStringsAnagramII
{
	public int minSteps(String s, String t)
	{
		int[] sTable = createCharFrequencyTable(s);
		int[] tTable = createCharFrequencyTable(t);

		int steps = 0;
		for (int i = 0; i < sTable.length; i++)
		{
			steps += Math.abs(sTable[i] - tTable[i]);
		}

		return steps;
	}

	private int[] createCharFrequencyTable(String word)
	{
		int[] pattern = new int[26];
		for (char ch : word.toCharArray())
		{
			if (Character.isAlphabetic(ch))
			{
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}
}
