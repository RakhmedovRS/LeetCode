package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
@LeetCode(id = 309, name = "Best Time to Buy and Sell Stock with Cooldown", url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/")
public class BestTimeToBuyAndSellStockWithCooldown
{
	public int maxProfit(int[] prices)
	{
		if (prices == null || prices.length == 0)
		{
			return 0;
		}

		int[] keep = new int[prices.length];
		int[] buy = new int[prices.length];
		int[] sell = new int[prices.length];
		keep[0] = 0;
		buy[0] = -prices[0];
		sell[0] = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++)
		{
			keep[i] = Math.max(keep[i - 1], sell[i - 1]);
			buy[i] = Math.max(buy[i - 1], keep[i - 1] - prices[i]);
			sell[i] = buy[i - 1] + prices[i];
		}

		return Math.max(keep[prices.length - 1], sell[prices.length - 1]);
	}
}
