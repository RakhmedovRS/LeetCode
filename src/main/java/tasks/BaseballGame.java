package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(
	id = 682,
	name = "Baseball Game",
	url = "https://leetcode.com/problems/baseball-game/",
	difficulty = Difficulty.EASY
)
public class BaseballGame
{
	public int calPoints(String[] ops)
	{
		LinkedList<Integer> list = new LinkedList<>();
		for (String op : ops)
		{
			if (Character.isDigit(op.charAt(op.length() - 1)))
			{
				list.addLast(Integer.parseInt(op));
			}
			else if ("C".equals(op))
			{
				if (!list.isEmpty())
				{
					list.removeLast();
				}
			}
			else if ("D".equals(op))
			{
				list.addLast(list.getLast() * 2);
			}
			else
			{
				int prev = list.removeLast();
				int prevPrev = list.removeLast();
				list.addLast(prevPrev);
				list.addLast(prev);
				list.addLast(prev + prevPrev);
			}
		}

		int res = 0;
		while (!list.isEmpty())
		{
			res += list.removeFirst();
		}

		return res;
	}
}
