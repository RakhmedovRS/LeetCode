package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
		id = 1957,
		name = "Delete Characters to Make Fancy String",
		url = "https://leetcode.com/problems/delete-characters-to-make-fancy-string/",
		difficulty = Difficulty.EASY
)
public class DeleteCharactersToMakeFancyString
{
	public String makeFancyString(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray())
		{
			if (sb.length() > 1 && sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 1) && sb.charAt(sb.length() - 1) == ch)
			{
				continue;
			}
			sb.append(ch);
		}

		return sb.toString();
	}
}
