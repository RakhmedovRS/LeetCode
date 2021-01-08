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
		return convertToString(word1).equals(convertToString(word2));
	}

	private String convertToString(String[] words)
	{
		StringBuilder sb = new StringBuilder();
		for (String word : words)
		{
			sb.append(word);
		}
		return sb.toString();
	}
}
