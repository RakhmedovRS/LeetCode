package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11/14/2021
 */
@LeetCode(
	id = 2073,
	name = "Time Needed to Buy Tickets",
	url = "https://leetcode.com/problems/time-needed-to-buy-tickets/",
	difficulty = Difficulty.EASY
)
public class TimeNeededToBuyTickets
{
	public int timeRequiredToBuy(int[] tickets, int k)
	{
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < tickets.length; i++)
		{
			list.addLast(i);
		}

		int time = 0;
		while (!list.isEmpty())
		{
			time++;
			int i = list.removeFirst();
			tickets[i]--;
			if (tickets[i] != 0)
			{
				list.addLast(i);
			}
			else if (i == k)
			{
				break;
			}
		}

		return time;
	}
}
