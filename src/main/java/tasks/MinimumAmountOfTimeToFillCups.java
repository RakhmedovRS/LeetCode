package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 7/11/2022
 */
@LeetCode(
		id = 2335,
		name = "Minimum Amount of Time to Fill Cups",
		url = "https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/",
		difficulty = Difficulty.EASY
)
public class MinimumAmountOfTimeToFillCups
{
	public int fillCups(int[] amount)
	{
		int sec = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> amount[b] - amount[a]);
		for (int i = 0; i < 3; i++)
		{
			if (amount[i] > 0)
			{
				pq.add(i);
			}
		}

		while (!pq.isEmpty())
		{
			int a = pq.remove();
			amount[a]--;

			if (!pq.isEmpty())
			{
				int b = pq.remove();
				amount[b]--;
				if (amount[b] > 0)
				{
					pq.add(b);
				}
			}

			if (amount[a] > 0)
			{
				pq.add(a);
			}

			sec++;
		}

		return sec;
	}
}
