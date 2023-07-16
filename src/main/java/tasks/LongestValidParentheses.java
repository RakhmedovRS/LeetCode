package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Apr-20
 */
@LeetCode(
		id = 32,
		name = "Longest Valid Parentheses",
		url = "https://leetcode.com/problems/longest-valid-parentheses/",
		difficulty = Difficulty.HARD
)
public class LongestValidParentheses
{
	public int longestValidParentheses(String s)
	{
		int max = 0;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(-1);

		char ch;
		for (int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if (ch == '(')
			{
				list.push(i);
			}
			else
			{
				if (list.isEmpty() || list.peek() == -1 || s.charAt(list.peek()) != '(')
				{
					list.push(i);
				}
				else
				{
					list.pop();
					max = Math.max(max, i - list.peek());
				}
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
		System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
	}
}
