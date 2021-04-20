package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(id = 746, name = "Min Cost Climbing Stairs", url = "https://leetcode.com/problems/min-cost-climbing-stairs/")
public class MinCostClimbingStairs
{
	public int minCostClimbingStairs(int[] cost)
	{
		if (cost == null || cost.length == 0)
		{
			return 0;
		}

		int[] memo = new int[cost.length];
		memo[0] = cost[0];
		memo[1] = cost[1];
		for (int i = 2; i < cost.length; i++)
		{
			memo[i] = Math.min(memo[i - 2], memo[i - 1]) + cost[i];
		}

		return Math.min(memo[memo.length - 2], memo[memo.length - 1]);
	}

	public static void main(String[] args)
	{
		new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
	}
}
