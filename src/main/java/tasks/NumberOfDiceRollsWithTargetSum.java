package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/2/2020
 */
@LeetCode(id = 1155, name = "Number of Dice Rolls With Target Sum", url = "https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/")
public class NumberOfDiceRollsWithTargetSum {
	public int numRollsToTarget(int d, int f, int target) {
		return (int) (dfs(d, f, target, new Long[d + 1][target + 1]) % 1_000_000_007);
	}

	private long dfs(int d, int f, int target, Long[][] memo) {
		if (d == 0 || target == 0) {
			return (d == 0 && target == 0) ? 1 : 0;
		}

		if (memo[d][target] != null) {
			return memo[d][target];
		}

		memo[d][target] = 0L;
		for (int i = 1; i <= f; i++) {
			if (target - i >= 0) {
				memo[d][target] += dfs(d - 1, f, target - i, memo) % 1_000_000_007;
			}
			else {
				break;
			}
		}

		memo[d][target] %= 1_000_000_007;

		return memo[d][target];
	}
}
