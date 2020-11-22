import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/22/2020
 */
@LeetCode(
	id = 1662,
	name = "Check If Two String Arrays are Equivalent",
	url = "https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/",
	difficulty = Difficulty.EASY
)
public class CheckIfTwoStringArraysAreEquivalent
{
	public boolean arrayStringsAreEqual(String[] word1, String[] word2)
	{
		StringBuilder a = new StringBuilder();
		for (String word : word1)
		{
			a.append(word);
		}

		StringBuilder b = new StringBuilder();
		for (String word : word2)
		{
			b.append(word);
		}

		return a.toString().equals(b.toString());
	}
}
