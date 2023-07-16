package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/25/2021
 */
@LeetCode(
		id = 2114,
		name = "Maximum Number of Words Found in Sentences",
		url = "https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/",
		difficulty = Difficulty.EASY
)
public class MaximumNumberOfWordsFoundInSentences
{
	public int mostWordsFound(String[] sentences)
	{
		int max = 0;
		for (String s : sentences)
		{
			max = Math.max(max, s.split(" ").length);
		}

		return max;
	}
}
