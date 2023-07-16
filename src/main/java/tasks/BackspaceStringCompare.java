package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(
		id = 844,
		name = "Backspace String Compare",
		url = "https://leetcode.com/problems/backspace-string-compare/",
		difficulty = Difficulty.EASY
)
public class BackspaceStringCompare
{
	public boolean backspaceCompare(String S, String T)
	{
		return processString(S).equals(processString(T));
	}

	private String processString(String string)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == '#')
			{
				if (sb.length() != 0)
				{
					sb.deleteCharAt(sb.length() - 1);
				}
			}
			else
			{
				sb.append(string.charAt(i));
			}
		}

		return sb.toString();
	}
}
