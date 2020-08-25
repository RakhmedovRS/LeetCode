import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 25-Aug-20
 */
@LeetCode(id = 983, name = "Minimum Cost For Tickets", url = "https://leetcode.com/problems/minimum-cost-for-tickets/")
public class MinimumCostForTickets
{
	public int mincostTickets(int[] days, int[] costs)
	{
		Queue<int[]> sevenDays = new LinkedList<>();
		Queue<int[]> thirtyDays = new LinkedList<>();

		int totalCost = 0;
		for (int day : days)
		{
			while (!sevenDays.isEmpty() && sevenDays.peek()[0] <= day)
			{
				sevenDays.poll();
			}

			sevenDays.offer(new int[]{day + 7, totalCost + costs[1]});

			while (!thirtyDays.isEmpty() && thirtyDays.peek()[0] <= day)
			{
				thirtyDays.poll();
			}

			thirtyDays.offer(new int[]{day + 30, totalCost + costs[2]});

			totalCost = Math.min(totalCost + costs[0], Math.min(sevenDays.peek()[1], thirtyDays.peek()[1]));
		}

		return totalCost;
	}
}
