package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Feb-20
 */
@LeetCode(
	id = 121,
	name = "Best Time to Buy and Sell Stock",
	url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
	difficulty = Difficulty.EASY
)
public class BestTimeToBuyAndSellStock
{
	public int maxProfit(int[] prices)
	{
		int min = prices[0];
		int max = 0;
		for (int i = 1; i < prices.length; i++)
		{
			max = Math.max(max, prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		return max;
	}
}
