package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 1/6/2024
 */
@LeetCode(
		id = 2998,
		name = "Minimum Number of Operations to Make X and Y Equal",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMakeXAndYEqual {
	public int minimumOperationsToMakeEqual(int x, int y) {
		int[] memo = new int[Math.max(x, y) + 11 + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[y] = 0;
		calculateMins(0, y, memo);
		return memo[x];
	}

	private void calculateMins(int count, int y, int[] memo) {
		if (y < 0 || y >= memo.length || count > memo[y]) {
			return;
		}

		memo[y] = count;
		calculateMins(count + 1, y * 11, memo);
		calculateMins(count + 1, y * 5, memo);
		calculateMins(count + 1, y + 1, memo);
		calculateMins(count + 1, y - 1, memo);
	}
}
