import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(id = 150, name = "Evaluate Reverse Polish Notation", url = "https://leetcode.com/problems/evaluate-reverse-polish-notation/")
public class EvaluateReversePolishNotation
{
	public int evalRPN(String[] tokens)
	{
		Deque<Integer> values = new LinkedList<>();
		for (String token : tokens)
		{
			switch (token)
			{
				case "+":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(a + b);
					break;
				}
				case "-":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(b - a);
					break;
				}
				case "*":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(a * b);
					break;
				}
				case "/":
				{
					Integer a = values.removeLast();
					Integer b = values.removeLast();
					values.addLast(b / a);
					break;
				}
				default:
				{
					values.addLast(Integer.parseInt(token));
					break;
				}
			}
		}

		return values.getLast();
	}

	public static void main(String[] args)
	{
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}
}
