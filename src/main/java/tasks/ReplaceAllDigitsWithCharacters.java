package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/1/2021
 */
@LeetCode(
	id = 1844,
	name = "Replace All Digits with Characters",
	url = "https://leetcode.com/problems/replace-all-digits-with-characters/",
	difficulty = Difficulty.MEDIUM
)
public class ReplaceAllDigitsWithCharacters
{
	public String replaceDigits(String s)
	{
		char[] chars = s.toCharArray();
		for (int i = 1; i < s.length(); i += 2)
		{
			chars[i] = (char) (chars[i - 1] + chars[i] - '0');
		}

		return String.valueOf(chars);
	}
}
