package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(id = 282, name = "Expression Add Operators", url = "https://leetcode.com/problems/expression-add-operators/")
public class ExpressionAddOperators
{
	public List<String> addOperators(String num, int target)
	{
		List<String> operations = new ArrayList<>();
		if (num == null || num.length() == 0)
		{
			return operations;
		}

		char[] values = num.toCharArray();
		explore(values, 0, operations, new LinkedList<>(), target);
		return operations;
	}

	private void explore(char[] values, int pos, List<String> operations, LinkedList<String> candidates, long target)
	{
		if (pos == values.length)
		{
			StringBuilder sb = new StringBuilder();
			for (String op : candidates)
			{
				sb.append(op);
			}
			String expression = sb.toString();
			if (target == evaluate(expression))
			{
				operations.add(expression);
			}
			return;
		}

		for (int step = 1; step + pos <= values.length; step++)
		{
			String sVal = String.valueOf(values, pos, step);
			if (sVal.length() > 1 && sVal.charAt(0) == '0')
			{
				break;
			}
			if (candidates.isEmpty())
			{
				candidates.add(sVal);
				explore(values, pos + step, operations, candidates, target);
				candidates.removeLast();
			}
			else
			{
				candidates.add("+");
				candidates.add(sVal);
				explore(values, pos + step, operations, candidates, target);
				candidates.removeLast();
				candidates.removeLast();

				candidates.add("-");
				candidates.add(sVal);
				explore(values, pos + step, operations, candidates, target);
				candidates.removeLast();
				candidates.removeLast();

				candidates.add("*");
				candidates.add(sVal);
				explore(values, pos + step, operations, candidates, target);
				candidates.removeLast();
				candidates.removeLast();
			}
		}
	}

	private long evaluate(String expression)
	{
		if (expression.contains("+"))
		{
			String[] parts = expression.split("\\+");
			Long res = null;
			for (String part : parts)
			{
				if (res != null)
				{
					res += evaluate(part);
				}
				else
				{
					res = evaluate(part);
				}
			}

			return res;
		}

		if (expression.contains("-"))
		{
			String[] parts = expression.split("\\-");
			Long res = null;
			for (String part : parts)
			{
				if (res != null)
				{
					res -= evaluate(part);
				}
				else
				{
					res = evaluate(part);
				}
			}

			return res;
		}

		if (expression.contains("*"))
		{
			String[] parts = expression.split("\\*");
			Long res = null;
			for (String part : parts)
			{
				if (res != null)
				{
					res *= evaluate(part);
				}
				else
				{
					res = evaluate(part);
				}
			}

			return res;
		}

		return Long.parseLong(expression);
	}

	public static void main(String[] args)
	{
		System.out.println(new ExpressionAddOperators().addOperators("232", 8));
		System.out.println(new ExpressionAddOperators().addOperators("105", 5));
		System.out.println(new ExpressionAddOperators().addOperators("123", 6));
		System.out.println(new ExpressionAddOperators().addOperators("3456237490", 9191));
	}
}
