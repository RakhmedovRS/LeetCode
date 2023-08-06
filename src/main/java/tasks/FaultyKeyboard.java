package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/6/2023
 */
@LeetCode(
		id = 2810,
		name = "Faulty Keyboard",
		url = "https://leetcode.com/problems/faulty-keyboard/description/",
		difficulty = Difficulty.EASY
)
public class FaultyKeyboard
{
	public String finalString(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch: s.toCharArray())
		{
			if (ch == 'i')
			{
				sb.reverse();
			}
			else
			{
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
