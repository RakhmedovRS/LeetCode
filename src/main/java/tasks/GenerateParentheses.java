package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(
		id = 22,
		name = "Generate Parentheses",
		url = "https://leetcode.com/problems/generate-parentheses/",
		difficulty = Difficulty.MEDIUM
)
public class GenerateParentheses
{
	public List<String> generateParenthesis(int n)
	{
		List<String> list = new ArrayList<>();
		dfs(n, n, new StringBuilder(), list);
		return list;
	}

	private void dfs(int left, int right, StringBuilder sb, List<String> list)
	{
		if (right == 0)
		{
			list.add(sb.toString());
			return;
		}

		if (left > 0)
		{
			sb.append('(');
			dfs(left - 1, right, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (left < right)
		{
			sb.append(')');
			dfs(left, right - 1, sb, list);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new GenerateParentheses().generateParenthesis(1));
		System.out.println(new GenerateParentheses().generateParenthesis(2));
		System.out.println(new GenerateParentheses().generateParenthesis(3));
		System.out.println(new GenerateParentheses().generateParenthesis(4));
		System.out.println(new GenerateParentheses().generateParenthesis(5));
	}
}
