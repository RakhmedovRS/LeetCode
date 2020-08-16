import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(id = 123, name = "Best Time to Buy and Sell Stock III", url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/")
public class BestTimeToBuyAndSellStockIII
{
	public int maxProfit(int[] prices)
	{
		int n = prices.length;
		if (n < 2)
		{
			return 0;
		}

		int[] left = new int[n];
		int minLeft = prices[0];
		for (int i = 1; i < n; i++)
		{
			left[i] = Math.max(left[i - 1], prices[i] - minLeft);
			minLeft = Math.min(minLeft, prices[i]);
		}

		int[] right = new int[n];
		int maxRight = prices[n - 1];
		for (int i = n - 2; i >= 0; i--)
		{
			right[i] = Math.max(right[i + 1], maxRight - prices[i]);
			maxRight = Math.max(maxRight, prices[i]);
		}

		int maxProfit = 0;
		for (int i = 0; i < n; i++)
		{
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		}

		return maxProfit;
	}

	public static void main(String[] args)
	{
		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5}));
	}
}
