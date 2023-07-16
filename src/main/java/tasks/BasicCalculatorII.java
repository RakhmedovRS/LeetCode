package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(
		id = 227,
		name = "Basic Calculator II",
		url = "https://leetcode.com/problems/basic-calculator-ii/",
		difficulty = Difficulty.MEDIUM
)
public class BasicCalculatorII
{
	public int calculate(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray())
		{
			if (Character.isDigit(ch) || ch == '*' || ch == '+' || ch == '-' || ch == '/')
			{
				sb.append(ch);
			}
		}

		s = sb.toString();

		LinkedList<Integer> numbers = new LinkedList<>();
		LinkedList<Character> operations = new LinkedList<>();
		int number = 0;
		char ch;
		for (int i = 0; i < s.length(); i++)
		{
			ch = s.charAt(i);
			if (Character.isDigit(ch))
			{
				number *= 10;
				number += s.charAt(i) - '0';
			}
			else if (ch == '+' || ch == '-')
			{
				numbers.addLast(number);
				number = 0;
				operations.addLast(ch);
			}
			else
			{
				int j = i;
				int secondNumber = 0;
				while (j + 1 < s.length() && Character.isDigit(s.charAt(j + 1)))
				{
					secondNumber *= 10;
					secondNumber += s.charAt(j + 1) - '0';
					j++;
				}

				if (ch == '*')
				{
					number *= secondNumber;
				}
				else
				{
					number /= secondNumber;
				}

				i = j;
			}

			if (i == s.length() - 1)
			{
				numbers.addLast(number);
			}
		}

		while (numbers.size() != 1)
		{
			char op = operations.removeFirst();
			if (op == '+')
			{
				numbers.addFirst(numbers.removeFirst() + numbers.removeFirst());
			}
			else
			{
				numbers.addFirst(numbers.removeFirst() - numbers.removeFirst());
			}
		}

		return numbers.getFirst();
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
