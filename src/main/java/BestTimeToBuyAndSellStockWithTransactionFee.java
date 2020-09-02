import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 02-Sep-20
 */
@LeetCode(id = 714, name = "Best Time to Buy and Sell Stock with Transaction Fee", url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/")
public class BestTimeToBuyAndSellStockWithTransactionFee
{
	public int maxProfit(int[] prices, int fee)
	{
		if (prices.length < 2)
		{
			return 0;
		}

		int[][] memo = new int[prices.length][2];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return dfs(prices, 0, fee, memo, 1);
	}

	private int dfs(int[] prices, int pos, int fee, int[][] memo, int canBuy)
	{
		if (pos == prices.length)
		{
			return 0;
		}

		if (memo[pos][canBuy] != -1)
		{
			return memo[pos][canBuy];
		}

		int max;
		if (canBuy == 1)
		{
			max = Math.max(-prices[pos] + dfs(prices, pos + 1, fee, memo, 0),
				dfs(prices, pos + 1, fee, memo, canBuy));
		}
		else
		{
			max = Math.max(prices[pos] - fee + dfs(prices, pos + 1, fee, memo, 1),
				dfs(prices, pos + 1, fee, memo, canBuy));
		}

		memo[pos][canBuy] = max;
		return max;
	}
}
