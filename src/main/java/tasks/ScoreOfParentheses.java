package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 16-Jul-20
 */
@LeetCode(
	id = 856,
	name = "Score of Parentheses",
	url = "https://leetcode.com/problems/score-of-parentheses/",
	difficulty = Difficulty.MEDIUM
)
public class ScoreOfParentheses
{
	public int scoreOfParentheses(String S)
	{
		if (S.isEmpty())
		{
			return 0;
		}

		if (S.equals("()"))
		{
			return 1;
		}

		int sum = 0;
		LinkedList<Integer> linkedList = new LinkedList<>();
		int balance = 0;
		for (int i = 0; i < S.length(); i++)
		{
			if (S.charAt(i) == '(')
			{
				linkedList.addLast(i);
				balance++;
			}
			else
			{
				balance--;

				if (balance == 0)
				{
					int start = linkedList.removeFirst();
					sum += Math.max(1, 2 * scoreOfParentheses(S.substring(start + 1, i)));
					linkedList.clear();
				}
			}
		}

		return sum;
	}
}
