package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/3/2020
 */
@LeetCode(id = 1402, name = "Reducing Dishes", url = "https://leetcode.com/problems/reducing-dishes/")
public class ReducingDishes {
	public int maxSatisfaction(int[] satisfaction) {
		Arrays.sort(satisfaction);
		return dfs(0, 0, satisfaction, new Integer[satisfaction.length][satisfaction.length]);
	}

	private int dfs(int pos, int used, int[] satisfaction, Integer[][] memo) {
		if (pos == satisfaction.length) {
			return 0;
		}

		if (memo[pos][used] != null) {
			return memo[pos][used];
		}

		int current = (used + 1) * satisfaction[pos];
		memo[pos][used] = Math.max(current + dfs(pos + 1, used + 1, satisfaction, memo), dfs(pos + 1, used, satisfaction, memo));

		return memo[pos][used];
	}
}
