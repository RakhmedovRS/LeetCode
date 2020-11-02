import common.LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(id = 20, name = "Valid Parentheses", url = "https://leetcode.com/problems/valid-parentheses/")
public class ValidParentheses
{
	public boolean isValid(String s)
	{
		LinkedList<Character> deque = new LinkedList<>();
		for (char ch : s.toCharArray())
		{
			if (ch == '(' || ch == '[' || ch == '{')
			{
				deque.addLast(ch);
			}
			else if (ch == ')')
			{
				if (deque.isEmpty() || deque.getLast() != '(')
				{
					return false;
				}
				deque.removeLast();
			}
			else if (ch == ']')
			{
				if (deque.isEmpty() || deque.getLast() != '[')
				{
					return false;
				}
				deque.removeLast();
			}
			else if (ch == '}')
			{
				if (deque.isEmpty() || deque.getLast() != '{')
				{
					return false;
				}
				deque.removeLast();
			}
		}

		return deque.isEmpty();
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidParentheses().isValid("()[]{}"));
	}
}
