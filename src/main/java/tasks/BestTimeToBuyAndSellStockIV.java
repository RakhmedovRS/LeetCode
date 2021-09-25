package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/18/2020
 */
@LeetCode(
	id = 188,
	name = "Best Time to Buy and Sell Stock IV",
	url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/",
	difficulty = Difficulty.HARD
)
public class BestTimeToBuyAndSellStockIV
{
	public int maxProfit(int k, int[] prices)
	{
		if (2 * k >= prices.length)
		{
			int max = 0;
			for (int i = 1; i < prices.length; i++)
			{
				if (prices[i] > prices[i - 1])
				{
					max += prices[i] - prices[i - 1];
				}
			}

			return max;
		}

		return dfs(0, k, prices, 0, new Integer[prices.length][k + 1][2]);
	}

	/*
	 * state = 0 -> can buy or skip;
	 * state = 1 -> can sell or skip;
	 */
	private int dfs(int day, int k, int[] prices, int state, Integer[][][] memo)
	{
		if (day >= prices.length || (k == 0 && state == 1))
		{
			return 0;
		}

		if (memo[day][k][state] != null)
		{
			return memo[day][k][state];
		}

		int doNothing = dfs(day + 1, k, prices, state, memo);
		int buyOrSell;
		if (state == 0)
		{
			buyOrSell = -prices[day] + dfs(day + 1, k, prices, 1, memo);
		}
		else
		{
			buyOrSell = prices[day] + dfs(day, k - 1, prices, 0, memo);
		}

		memo[day][k][state] = Math.max(doNothing, buyOrSell);

		return memo[day][k][state];
	}

	public static void main(String[] args)
	{
		System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{6, 1, 3, 2, 4, 7}));
		System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{1, 2, 4}));
		System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
		System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{2, 4, 1}));
	}
}
