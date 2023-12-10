package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Sep-20
 */
@LeetCode(
		id = 714,
		name = "Best Time to Buy and Sell Stock with Transaction Fee",
		url = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/",
		difficulty = Difficulty.MEDIUM
)
public class BestTimeToBuyAndSellStockWithTransactionFee {
	enum State {
		CAN_BUY(0),
		MUST_SELL(1);

		int code;

		State(int code) {
			this.code = code;
		}
	}

	public int maxProfit(int[] prices, int fee) {
		return dfs(prices, fee, new Integer[prices.length][2], State.CAN_BUY, 0);
	}

	private int dfs(int[] prices, int fee, Integer[][] memo, State state, int pos) {
		if (pos == prices.length) {
			return 0;
		}

		if (memo[pos][state.code] != null) {
			return memo[pos][state.code];
		}


		if (state == State.CAN_BUY) {
			memo[pos][state.code] = Math.max(-prices[pos] - fee + dfs(prices, fee, memo, State.MUST_SELL, pos + 1),
					dfs(prices, fee, memo, state, pos + 1));
		}
		else {
			memo[pos][state.code] = Math.max(prices[pos] + dfs(prices, fee, memo, State.CAN_BUY, pos + 1),
					dfs(prices, fee, memo, state, pos + 1));
		}

		memo[pos][state.code] = Math.max(memo[pos][state.code], 0);

		return memo[pos][state.code];
	}
}
