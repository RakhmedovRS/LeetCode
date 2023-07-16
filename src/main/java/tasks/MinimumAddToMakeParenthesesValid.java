package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 1/22/2021
 */
@LeetCode(
		id = 921,
		name = "Minimum Add to Make Parentheses Valid",
		url = "https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumAddToMakeParenthesesValid
{
	public int minAddToMakeValid(String S)
	{
		int additions = 0;
		LinkedList<Character> stack = new LinkedList<>();
		for (char ch : S.toCharArray())
		{
			if (ch == '(')
			{
				if (!stack.isEmpty() && stack.peek() == ')')
				{
					additions += stack.size();
					stack.clear();
				}
				stack.push(ch);
			}
			else
			{
				if (!stack.isEmpty() && stack.peek() == '(')
				{
					stack.pop();
				}
				else
				{
					stack.push(ch);
				}
			}
		}

		additions += stack.size();

		return additions;
	}
}
