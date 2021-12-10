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
		if (prices == null || prices.length < 2)
		{
			return 0;
		}
		int maxProfit = 0;
		int min = Integer.MAX_VALUE;
		for (int price : prices)
		{
			if (price < min)
			{
				min = price;
			}
			else
			{
				maxProfit = Math.max(maxProfit, price - min);
			}
		}

		return maxProfit;
	}
}
