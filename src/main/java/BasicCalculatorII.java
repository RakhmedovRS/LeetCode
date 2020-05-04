import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(id = 227, name = "Basic Calculator II", url = "https://leetcode.com/problems/basic-calculator-ii/")
public class BasicCalculatorII
{
	public int calculate(String string)
	{
		if (string == null)
		{
			return 0;
		}

		string = string.replaceAll(" ", "");
		if (string.isEmpty())
		{
			return 0;
		}

		Deque<Integer> values = new LinkedList<>();
		Deque<Character> operators = new LinkedList<>();
		int value = 0;
		boolean isNumber = false;
		for (int i = 0; i < string.length(); i++)
		{
			char ch = string.charAt(i);
			if (Character.isDigit(ch))
			{
				if (isNumber)
				{
					value *= 10;
					value += ch - '0';
				}
				else
				{
					isNumber = true;
					value = ch - '0';
				}

				if (i == string.length() - 1)
				{
					values.addLast(value);
				}
			}
			else if (ch == '+' || ch == '-')
			{
				if (isNumber)
				{
					values.addLast(value);
				}
				isNumber = false;
				operators.addLast(ch);
			}
			else
			{
				if (isNumber)
				{
					values.addLast(value);
				}
				isNumber = false;
				int leftOperand = values.removeLast();
				int rightOperand = 0;
				i++;
				while (i < string.length() && Character.isDigit(string.charAt(i)))
				{
					rightOperand *= 10;
					rightOperand += string.charAt(i) - '0';
					i++;
				}

				if (ch == '*')
				{
					values.addLast(leftOperand * rightOperand);
				}
				else
				{
					values.addLast(leftOperand / rightOperand);
				}

				if (i != string.length())
				{
					i--;
				}
			}
		}

		while (!operators.isEmpty())
		{
			Character operator = operators.removeFirst();
			int leftOperand = values.removeFirst();
			int rightOperand = values.removeFirst();

			if (operator == '+')
			{
				values.addFirst(leftOperand + rightOperand);
			}
			else
			{
				values.addFirst(leftOperand - rightOperand);
			}
		}

		return values.peek();
	}

	public static void main(String[] args)
	{
		System.out.println(new BasicCalculatorII().calculate("1+1-1"));
		System.out.println(new BasicCalculatorII().calculate("1-1+1"));
		System.out.println(new BasicCalculatorII().calculate("0-2147483647"));
		System.out.println(new BasicCalculatorII().calculate("3+2*2"));
		System.out.println(new BasicCalculatorII().calculate(" 3/2 "));
		System.out.println(new BasicCalculatorII().calculate(" 3+5 / 2 "));
	}
}
