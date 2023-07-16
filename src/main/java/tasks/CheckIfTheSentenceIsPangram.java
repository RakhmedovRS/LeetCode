package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/18/2021
 */
@LeetCode(
		id = 1832,
		name = "Check if the Sentence Is Pangram",
		url = "https://leetcode.com/problems/check-if-the-sentence-is-pangram/",
		difficulty = Difficulty.EASY
)
public class CheckIfTheSentenceIsPangram
{
	public boolean checkIfPangram(String sentence)
	{
		int[] memo = new int[26];
		for (char ch : sentence.toCharArray())
		{
			memo[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++)
		{
			if (memo[i] == 0)
			{
				return false;
			}
		}

		return true;
	}
}
