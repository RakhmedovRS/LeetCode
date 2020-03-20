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
	static Map<Character, Character> parentheses;

	static
	{
		parentheses = new HashMap<>();
		parentheses.put(')', '(');
		parentheses.put(']', '[');
		parentheses.put('}', '{');
	}

	public boolean isValid(String A)
	{
		Deque<Character> stack = new LinkedList<>();
		for (char ch : A.toCharArray())
		{
			if (!parentheses.containsKey(ch))
			{
				stack.push(ch);
			}
			else if (stack.poll() != parentheses.get(ch))
			{
				return false;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidParentheses().isValid("()[]{}"));
	}
}
