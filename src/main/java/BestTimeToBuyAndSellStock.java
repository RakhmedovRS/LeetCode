import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Feb-20
 */
@LeetCode(id = 121, name = "Best Time to Buy and Sell Stock", url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/")
public class BestTimeToBuyAndSellStock
{
	public int maxProfit(int[] prices)
	{
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (prices[i] < minPrice)
			{
				minPrice = prices[i];
			}
			else if (maxProfit < prices[i] - minPrice)
			{
				maxProfit = prices[i] - minPrice;
			}
		}

		return maxProfit;
	}
}
