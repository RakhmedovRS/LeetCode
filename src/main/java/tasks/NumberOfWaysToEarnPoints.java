package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 3/9/2023
 */
@LeetCode(
		id = 2585,
		name = "Number of Ways to Earn Points",
		url = "https://leetcode.com/problems/number-of-ways-to-earn-points/",
		difficulty = Difficulty.HARD
)
public class NumberOfWaysToEarnPoints {
	int MOD = 1_000_000_007;

	public int waysToReachTarget(int target, int[][] types) {
		Map<Integer, Integer>[] map = new HashMap[types.length];
		for (int i = 0; i < types.length; i++) {
			map[i] = new HashMap<>();
		}

		int res = dfs(0, target, types, map);

		return res;
	}

	private int dfs(int typePos, int target, int[][] types, Map<Integer, Integer>[] map) {
		if (target == 0) {
			return 1;
		}

		if (typePos >= types.length || target < 0) {
			return 0;
		}

		if (map[typePos].containsKey(target)) {
			return map[typePos].get(target);
		}

		long res = dfs(typePos + 1, target, types, map);
		int[] type = types[typePos];
		int count = type[0];
		int cost = type[1];
		int t = target;
		while (count-- > 0) {
			t -= cost;
			res = (res + dfs(typePos + 1, t, types, map)) % MOD;
		}

		map[typePos].put(target, (int) res);

		return (int) res;
	}
}
