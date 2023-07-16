package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/24/2021
 */
@LeetCode(
		id = 709,
		name = "To Lower Case",
		url = "https://leetcode.com/problems/to-lower-case/",
		difficulty = Difficulty.EASY
)
public class ToLowerCase
{
	public String toLowerCase(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray())
		{
			sb.append(Character.toLowerCase(ch));
		}

		return sb.toString();
	}
}
