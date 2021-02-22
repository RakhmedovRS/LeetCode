import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/14/2020
 */
@LeetCode(
	id = 524,
	name = "Longest Word in Dictionary through Deleting",
	url = "https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/",
	difficulty = Difficulty.MEDIUM
)
public class LongestWordInDictionaryThroughDeleting
{
	public String findLongestWord(String s, List<String> d)
	{
		d.sort((a, b) ->
		{
			if (a.length() == b.length())
			{
				return a.compareTo(b);
			}

			return b.length() - a.length();
		});

		for (String word : d)
		{
			if (canCreate(s, word))
			{
				return word;
			}
		}

		return "";
	}

	private boolean canCreate(String current, String target)
	{
		int tPos = 0;
		for (int cPos = 0; cPos < current.length() && tPos < target.length(); cPos++)
		{
			if (current.charAt(cPos) == target.charAt(tPos))
			{
				tPos++;
			}
		}

		return tPos == target.length();
	}
}
