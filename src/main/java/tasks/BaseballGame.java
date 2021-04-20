package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(id = 682, name = "Baseball Game", url = "https://leetcode.com/problems/baseball-game/")
public class BaseballGame
{
	public int calPoints(String[] ops)
	{
		Deque<Integer> integers = new LinkedList<>();
		for (String op : ops)
		{
			if (op.equals("+"))
			{
				if (integers.size() == 1)
				{
					integers.push(integers.peek() * 2);
					continue;
				}

				int b = integers.pop();
				int a = integers.pop();
				int c = a + b;
				integers.push(a);
				integers.push(b);
				integers.push(c);
			}
			else if (op.equals("C"))
			{
				integers.pop();
			}
			else if (op.equals("D"))
			{
				integers.push(integers.peek() * 2);
			}
			else
			{
				integers.push(Integer.parseInt(op));
			}
		}

		int res = 0;
		for (int val : integers)
		{
			res += val;
		}

		return res;
	}
}
