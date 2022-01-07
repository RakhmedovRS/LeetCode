package tasks;

import common.LeetCode;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
@LeetCode(id = 678, name = "Valid Parenthesis String", url = "https://leetcode.com/problems/valid-parenthesis-string/")
public class ValidParenthesisString
{
	public boolean checkValidString(String expression)
	{
		if (expression == null || expression.length() == 0)
		{
			return true;
		}

		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < expression.length(); i++)
		{
			char ch = expression.charAt(i);
			if (ch == '*' || ch == '(')
			{
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

		Deque<Map.Entry<Integer, Character>> parenthesis = new LinkedList<>();
		Deque<Map.Entry<Integer, Character>> stars = new LinkedList<>();
		int i = 0;
		while (!stack.isEmpty())
		{
			Character ch = stack.removeLast();
			if (ch == '*')
			{
				stars.push(new AbstractMap.SimpleEntry<>(i++, ch));
			}
			else if (ch == '(')
			{
				parenthesis.push(new AbstractMap.SimpleEntry<>(i++, ch));
			}
			else
			{
				if (!parenthesis.isEmpty())
				{
					parenthesis.pop();
				}
				else if (!stars.isEmpty())
				{
					stars.pop();
				}
				else
				{
					return false;
				}
			}
		}

		while (!parenthesis.isEmpty())
		{
			Map.Entry<Integer, Character> pair = parenthesis.pop();
			if (stars.isEmpty())
			{
				return false;
			}

			if (stars.pop().getKey() < pair.getKey())
			{
				return false;
			}
		}

		return true;
	}
}
