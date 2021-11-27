package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/27/2021
 */
@LeetCode(
	id = 2087,
	name = "Minimum Cost Homecoming of a Robot in a Grid",
	url = "https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumCostHomecomingOfRobotInGrid
{
	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts)
	{
		int cost = 0;
		while (startPos[0] != homePos[0])
		{
			if (startPos[0] < homePos[0])
			{
				startPos[0]++;
			}
			else
			{
				startPos[0]--;
			}
			cost += rowCosts[startPos[0]];
		}

		while (startPos[1] != homePos[1])
		{
			if (startPos[1] < homePos[1])
			{
				startPos[1]++;
			}
			else
			{
				startPos[1]--;
			}
			cost += colCosts[startPos[1]];
		}

		return cost;
	}
}
