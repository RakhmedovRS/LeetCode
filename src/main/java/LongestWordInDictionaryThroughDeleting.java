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
		String answer = "";
		for (String string : d)
		{
			if (canBeCreated(s, string))
			{
				if (string.length() > answer.length())
				{
					answer = string;
				}
				else if (string.length() == answer.length())
				{
					if (string.compareTo(answer) < 0)
					{
						answer = string;
					}
				}
			}
		}

		return answer;
	}

	private boolean canBeCreated(String origin, String target)
	{
		int tPos = 0;
		for (int i = 0; i < origin.length() && tPos < target.length(); i++)
		{
			if (origin.charAt(i) == target.charAt(tPos))
			{
				tPos++;
			}
		}

		return tPos == target.length();
	}
}
