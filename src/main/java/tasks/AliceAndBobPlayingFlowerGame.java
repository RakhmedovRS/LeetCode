package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-27
 */
@LeetCode(
		id = 3021,
		name = "Alice and Bob Playing Flower Game",
		url = "https://leetcode.com/problems/alice-and-bob-playing-flower-game/description/",
		difficulty = Difficulty.MEDIUM
)
public class AliceAndBobPlayingFlowerGame {
	public long flowerGame(int n, int m) {
		long[] N = new long[2];
		for (int i = 1; i <= n; i++) {
			N[i % 2]++;
		}

		long[] M = new long[2];
		for (int i = 1; i <= m; i++) {
			M[i % 2]++;
		}

		long res = N[0] * M[1] + N[1] * M[0];

		return res;
	}
}