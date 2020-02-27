package main.java;

/**
 * Best Time to Buy and Sell Stock II
 * LeetCode 122
 *
 * @author RakhmedovRS
 * @created 27-Feb-20
 */
public class BestTimeToBuyAndSellStockII
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
			else if (i + 1 == prices.length || prices[i] > prices[i + 1])
			{
				maxProfit += prices[i] - minPrice;
				minPrice = Integer.MAX_VALUE;
			}
		}

		return maxProfit;
	}
}
