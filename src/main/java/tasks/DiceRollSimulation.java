package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/2/2020
 */
@LeetCode(
		id = 1223,
		name = "Dice Roll Simulation",
		url = "https://leetcode.com/problems/dice-roll-simulation/",
		difficulty = Difficulty.HARD
)
public class DiceRollSimulation {
	private final int MOD = 1_000_000_007;

	public int dieSimulator(int n, int[] rollMax) {
		return dfs(n, 0, 0, rollMax, new Integer[n + 1][6][16]);
	}

	private int dfs(int n, int tail, int repeat, int[] rollMax, Integer[][][] memo) {
		if (n == 0) {
			return 1;
		}

		if (memo[n][tail][repeat] != null) {
			return memo[n][tail][repeat];
		}

		memo[n][tail][repeat] = 0;
		for (int dice = 0; dice < 6; dice++) {
			if (dice != tail && rollMax[dice] >= 1) {
				memo[n][tail][repeat] += dfs(n - 1, dice, 1, rollMax, memo) % MOD;
				memo[n][tail][repeat] %= MOD;
			}

			if (dice == tail && rollMax[dice] >= repeat + 1) {
				memo[n][tail][repeat] += dfs(n - 1, dice, repeat + 1, rollMax, memo) % MOD;
				memo[n][tail][repeat] %= MOD;
			}
		}

		memo[n][tail][repeat] %= MOD;
		return memo[n][tail][repeat];
	}
}
