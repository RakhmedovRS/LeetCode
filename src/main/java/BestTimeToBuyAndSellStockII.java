import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Feb-20
 */
@LeetCode(id = 122, name = "Best Time to Buy and Sell Stock II", url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/")
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
