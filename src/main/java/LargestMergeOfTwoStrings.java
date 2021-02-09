import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/9/2021
 */
@LeetCode(
	id = 1754,
	name = "Largest Merge Of Two Strings",
	url = "https://leetcode.com/problems/largest-merge-of-two-strings/",
	difficulty = Difficulty.MEDIUM
)
public class LargestMergeOfTwoStrings
{
	public String largestMerge(String word1, String word2)
	{
		StringBuilder sb = new StringBuilder();
		int pos1 = 0;
		int pos2 = 0;
		while (pos1 < word1.length() || pos2 < word2.length())
		{
			if (pos1 < word1.length() && pos2 < word2.length())
			{
				if (word1.substring(pos1).compareTo(word2.substring(pos2)) >= 0)
				{

					sb.append(word1.charAt(pos1++));
				}
				else
				{
					sb.append(word2.charAt(pos2++));
				}
			}
			else if (pos1 < word1.length())
			{
				sb.append(word1.charAt(pos1++));
			}
			else
			{
				sb.append(word2.charAt(pos2++));
			}
		}

		return sb.toString();
	}
}
