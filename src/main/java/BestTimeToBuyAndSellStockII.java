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
		if (prices == null || prices.length <= 1)
		{
			return 0;
		}

		int maxProfit = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int price : prices)
		{
			if (price < min)
			{
				min = price;
			}
			else if (price > max)
			{
				maxProfit += price - min;
				min = price;
				max = Integer.MIN_VALUE;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args)
	{
		System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{2, 1, 2, 0, 1}));
		System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
		System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
		System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
}
