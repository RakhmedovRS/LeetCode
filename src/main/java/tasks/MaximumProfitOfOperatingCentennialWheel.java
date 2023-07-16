package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
@LeetCode(
		id = 1599,
		name = "Maximum Profit of Operating a Centennial Wheel",
		url = "https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumProfitOfOperatingCentennialWheel
{
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost)
	{
		int maxProfit = -1;
		int maxSteps = 0;
		int currentProfit = 0;
		int currentSteps = 0;
		int wait = 0;
		int i = 0;
		int passengers;
		while (i < customers.length || wait > 0)
		{
			currentSteps++;
			if (i < customers.length)
			{
				wait += customers[i++];
			}

			passengers = Math.min(4, wait);
			currentProfit += passengers * boardingCost - runningCost;
			if (currentProfit > maxProfit)
			{
				currentProfit = maxProfit;
				maxSteps = currentSteps;
			}
			wait -= passengers;
		}

		return maxSteps == 0 ? -1 : maxSteps;
	}
}
