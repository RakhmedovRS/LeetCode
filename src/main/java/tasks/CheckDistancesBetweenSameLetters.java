package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/8/2022
 */
@LeetCode(
		id = 2399,
		name = "Check Distances Between Same Letters",
		url = "https://leetcode.com/problems/check-distances-between-same-letters/",
		difficulty = Difficulty.EASY
)
public class CheckDistancesBetweenSameLetters {
	public boolean checkDistances(String s, int[] distance) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < 26; i++) {
			int prev = -1;
			for (int pos = 0; pos < chars.length; pos++) {
				if (i == (chars[pos] - 'a')) {
					if (prev == -1) {
						prev = pos;
					}
					else {
						if ((pos - prev) - 1 != distance[i]) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}
}
