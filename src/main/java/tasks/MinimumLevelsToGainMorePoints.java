package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-30
 */
@LeetCode(
		id = 3096,
		name = "Minimum Levels to Gain More Points",
		url = "https://leetcode.com/problems/minimum-levels-to-gain-more-points/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumLevelsToGainMorePoints {
	public int minimumLevels(int[] possible) {
		int[] rightToLeft = new int[possible.length];

		for (int i = possible.length - 1; i >= 0; i--) {
			if (i < possible.length - 1) {
				rightToLeft[i] += rightToLeft[i + 1];
			}
			rightToLeft[i] += possible[i] == 0 ? -1 : 1;
		}

		int dan = 0;
		for (int i = 0; i < possible.length - 1; i++) {
			dan += possible[i] == 0 ? -1 : 1;
			if (dan > rightToLeft[i + 1]) {
				return i + 1;
			}
		}

		return -1;
	}
}