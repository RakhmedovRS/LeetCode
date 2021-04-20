package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(id = 22, name = "Generate Parentheses", url = "https://leetcode.com/problems/generate-parentheses/")
public class GenerateParentheses
{
	public List<String> generateParenthesis(int n)
	{
		List<String> answer = new ArrayList<>();
		dfs(n,n, new StringBuilder(), answer::add);
		return answer;
	}

	private void dfs(int left, int right, StringBuilder sb, Consumer<String> consumer)
	{
		if (left == 0 && right == 0)
		{
			consumer.accept(sb.toString());
			return;
		}
		else if (left == 0)
		{
			sb.append(')');
			dfs(left, right - 1, sb, consumer);
			sb.deleteCharAt(sb.length() - 1);
			return;
		}

		if (left == right)
		{
			sb.append('(');
			dfs(left - 1, right, sb, consumer);
			sb.deleteCharAt(sb.length() - 1);
		}
		else
		{
			sb.append(')');
			dfs(left, right - 1, sb, consumer);
			sb.deleteCharAt(sb.length() - 1);

			sb.append('(');
			dfs(left - 1, right, sb, consumer);
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
