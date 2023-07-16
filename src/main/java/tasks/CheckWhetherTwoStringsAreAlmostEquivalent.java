package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/13/2021
 */
@LeetCode(
		id = 2068,
		name = "Check Whether Two Strings are Almost Equivalent",
		url = "https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/",
		difficulty = Difficulty.EASY
)
public class CheckWhetherTwoStringsAreAlmostEquivalent
{
	public boolean checkAlmostEquivalent(String word1, String word2)
	{
		int[] a = createFreqTable(word1);
		int[] b = createFreqTable(word2);

		for (int i = 0; i < 26; i++)
		{
			if (Math.abs(a[i] - b[i]) > 3)
			{
				return false;
			}
		}

		return true;
	}

	private int[] createFreqTable(String word)
	{
		int[] chars = new int[26];
		for (int i = 0; i < word.length(); i++)
		{
			chars[word.charAt(i) - 'a']++;
		}
		return chars;
	}
}
