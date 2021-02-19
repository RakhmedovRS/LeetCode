import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(
		id = 1249,
		name = "Minimum Remove to Make Valid Parentheses",
		url = "https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumRemoveToMakeValidParentheses
{
	public String minRemoveToMakeValid(String s)
	{
		boolean[] used = new boolean[s.length()];
		char[] chars = s.toCharArray();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < chars.length; i++)
		{
			if (Character.isLetter(chars[i]))
			{
				used[i] = true;
			}
			else if (chars[i] == '(')
			{
				list.addLast(i);
			}
			else
			{
				if (list.isEmpty())
				{
					used[i] = false;
				}
				else
				{
					if (chars[list.getLast()] == '(')
					{
						used[list.removeLast()] = true;
						used[i] = true;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < used.length; i++)
		{
			if (used[i])
			{
				sb.append(chars[i]);
			}
		}

		return sb.toString();
	}
}
