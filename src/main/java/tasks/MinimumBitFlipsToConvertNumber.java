package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/3/2022
 */
@LeetCode(
		id = 2220,
		name = "Minimum Bit Flips to Convert Number",
		url = "https://leetcode.com/problems/minimum-bit-flips-to-convert-number/",
		difficulty = Difficulty.EASY
)
public class MinimumBitFlipsToConvertNumber {
	public int minBitFlips(int start, int goal) {
		int diff = 0;
		while (start > 0 || goal > 0) {
			if ((start & 1) != (goal & 1)) {
				diff++;
			}
			start >>= 1;
			goal >>= 1;
		}

		return diff;
	}
}
