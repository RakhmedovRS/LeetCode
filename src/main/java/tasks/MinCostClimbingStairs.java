package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(
	id = 746,
	name = "Min Cost Climbing Stairs",
	url = "https://leetcode.com/problems/min-cost-climbing-stairs/",
	difficulty = Difficulty.EASY
)
public class MinCostClimbingStairs
{
	public int minCostClimbingStairs(int[] cost)
	{
		for (int i = 2; i < cost.length; i++)
		{
			cost[i] += Math.min(cost[i - 2], cost[i - 1]);
		}

		return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
	}

	public static void main(String[] args)
	{
		new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
	}
}
