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
		Integer[] memo = new Integer[days.length];
		return minCostTickets(days, costs, 0, memo);
	}

	private int minCostTickets(int[] days, int[] cost, int index, Integer[] memo)
	{
		if (index >= days.length)
		{
			return 0;
		}

		if (memo[index] != null)
		{
			return memo[index];
		}

		int index7 = index + 1;
		int index30 = index + 1;
		while (index7 < days.length && days[index] + 7 > days[index7])
		{
			index7++;
		}

		while (index30 < days.length && days[index] + 30 > days[index30])
		{
			index30++;
		}

		int oneDay = cost[0] + minCostTickets(days, cost, index + 1, memo);
		int sevenDays = cost[1] + minCostTickets(days, cost, index7, memo);
		int thirtyDays = cost[2] + minCostTickets(days, cost, index30, memo);

		memo[index] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
		return memo[index];
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumCostForTickets().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
		System.out.println(new MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
	}
}
