package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/28/2020
 */
@LeetCode(
		id = 1668,
		name = "Maximum Repeating Substring",
		url = "https://leetcode.com/problems/maximum-repeating-substring/",
		difficulty = Difficulty.EASY
)
public class MaximumRepeatingSubstring
{
	public int maxRepeating(String sequence, String word)
	{
		int count = 0;
		StringBuilder sb = new StringBuilder(word);
		int i = 1;
		while (sb.length() <= sequence.length())
		{
			if (sequence.contains(sb.toString()))
			{
				count = i;
			}
			i++;
			sb.append(word);
		}

		return count;
	}
}
