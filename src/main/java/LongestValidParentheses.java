import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Apr-20
 */
@LeetCode(id = 32, name = "Longest Valid Parentheses", url = "https://leetcode.com/problems/longest-valid-parentheses/")
public class LongestValidParentheses
{
	public int longestValidParentheses(String parentheses)
	{
		int result = 0;
		if (parentheses == null || parentheses.length() <= 1)
		{
			return result;
		}

		Deque<Integer> stack = new LinkedList<>();
		stack.push(-1);
		for (int i = 0; i < parentheses.length(); i++)
		{
			if (parentheses.charAt(i) == '(')
			{
				stack.push(i);
			}
			else if (parentheses.charAt(i) == ')')
			{
				if (stack.isEmpty() || stack.peek() == -1 || parentheses.charAt(stack.peek()) != '(')
				{
					stack.push(i);
				}
				else
				{
					stack.pop();
					result = Math.max(result, i - stack.peek());
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
		System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
	}
}
