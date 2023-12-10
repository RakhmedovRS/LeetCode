package tasks;

import common.Difficulty;
import common.LeetCode;

@LeetCode(
		id = 1140,
		name = "Stone Game II",
		url = "https://leetcode.com/problems/stone-game-ii/",
		difficulty = Difficulty.MEDIUM
)
public class StoneGameII {
	public int stoneGameII(int[] piles) {
		for (int i = piles.length - 2; i >= 0; i--) {
			piles[i] += piles[i + 1];
		}

		return dfs(0, piles, new Integer[piles.length][piles.length], 1);
	}

	private int dfs(int pos, int[] prevSum, Integer[][] memo, int m) {
		if (pos + m * 2 >= prevSum.length) {
			return prevSum[pos];
		}

		if (memo[pos][m] != null) {
			return memo[pos][m];
		}

		memo[pos][m] = 0;
		int current;
		for (int i = 1; i <= m * 2; i++) {
			current = prevSum[pos] - prevSum[pos + i];
			memo[pos][m] = Math.max(memo[pos][m], current + prevSum[pos + i] - dfs(pos + i, prevSum, memo, Math.max(i, m)));
		}

		return memo[pos][m];
	}
}
