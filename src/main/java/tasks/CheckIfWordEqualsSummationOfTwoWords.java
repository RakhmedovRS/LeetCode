package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/30/2021
 */
@LeetCode(
		id = 1880,
		name = "Check if Word Equals Summation of Two Words",
		url = "https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/",
		difficulty = Difficulty.EASY
)
public class CheckIfWordEqualsSummationOfTwoWords
{
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord)
	{
		return getNumber(firstWord) + getNumber(secondWord) == getNumber(targetWord);
	}

	private int getNumber(String string)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch : string.toCharArray())
		{
			sb.append(ch - 'a');
		}

		return Integer.parseInt(sb.toString());
	}
}
