package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/7/2020
 */
@LeetCode(
		id = 301,
		name = "Remove Invalid Parentheses",
		url = "https://leetcode.com/problems/remove-invalid-parentheses/",
		difficulty = Difficulty.HARD
)
public class RemoveInvalidParentheses
{
	public List<String> removeInvalidParentheses(String s)
	{
		Set<String> answer = new HashSet<>();
		dfs(0, s.toCharArray(), new StringBuilder(s.length()), answer, 0, new int[]{Integer.MAX_VALUE});
		return new ArrayList<>(answer);
	}

	private void dfs(int pos, char[] chars, StringBuilder sb, Set<String> answer, int removes, int[] min)
	{
		if (pos == chars.length)
		{
			if (isValid(sb))
			{
				if (removes == min[0])
				{
					answer.add(sb.toString());
				}
				if (removes < min[0])
				{
					answer.clear();
					answer.add(sb.toString());
					min[0] = removes;
				}
			}
			return;
		}

		if (chars[pos] == '(')
		{
			dfs(pos + 1, chars, sb, answer, removes + 1, min);

			sb.append('(');
			dfs(pos + 1, chars, sb, answer, removes, min);
			sb.deleteCharAt(sb.length() - 1);
		}
		else if (chars[pos] == ')')
		{
			dfs(pos + 1, chars, sb, answer, removes + 1, min);
			sb.append(')');
			dfs(pos + 1, chars, sb, answer, removes, min);
			sb.deleteCharAt(sb.length() - 1);
		}
		else
		{
			sb.append(chars[pos]);
			dfs(pos + 1, chars, sb, answer, removes, min);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private boolean isValid(StringBuilder sb)
	{
		LinkedList<Character> deque = new LinkedList<>();
		for (int i = 0; i < sb.length(); i++)
		{
			if (sb.charAt(i) == '(')
			{
				deque.addLast(sb.charAt(i));
			}
			else if (sb.charAt(i) == ')')
			{
				if (deque.isEmpty())
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
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(")(f"));
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
		System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
	}
}
