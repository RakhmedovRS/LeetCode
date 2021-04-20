package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Aug-20
 */
@LeetCode(id = 983, name = "Minimum Cost For Tickets", url = "https://leetcode.com/problems/minimum-cost-for-tickets/")
public class MinimumCostForTickets
{
	public int mincostTickets(int[] days, int[] costs)
	{
		return dfs(0, days[0], days, costs, new Integer[396][396]);
	}

	private int dfs(int pos, int currentTicket, int[] days, int[] costs, Integer[][] memo)
	{
		if (pos == days.length)
		{
			return 0;
		}

		if (memo[pos][currentTicket] != null)
		{
			return memo[pos][currentTicket];
		}

		if (currentTicket > days[pos])
		{
			return memo[pos][currentTicket] = dfs(pos + 1, currentTicket, days, costs, memo);
		}
		else
		{
			int oneDay = costs[0] + dfs(pos, days[pos] + 1, days, costs, memo);
			int sevenDays = costs[1] + dfs(pos, days[pos] + 7, days, costs, memo);
			int thirtyDays = costs[2] + dfs(pos, days[pos] + 30, days, costs, memo);
			return memo[pos][currentTicket] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumCostForTickets().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
		System.out.println(new MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
	}
}
