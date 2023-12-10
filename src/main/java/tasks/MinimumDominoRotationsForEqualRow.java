package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(
		id = 1007,
		name = "Minimum Domino Rotations For Equal Row",
		url = "https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumDominoRotationsForEqualRow {
	public int minDominoRotations(int[] A, int[] B) {
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= 6; i++) {
			int down = 0;
			int up = 0;
			for (int pos = 0; pos < A.length; pos++) {
				if (A[pos] == i) {
					up++;
				}
				else if (B[pos] == i) {
					down++;
				}
			}

			if (up + down == A.length) {
				min = Math.min(min, down);
			}

			down = 0;
			up = 0;
			for (int pos = 0; pos < A.length; pos++) {
				if (B[pos] == i) {
					down++;
				}
				else if (A[pos] == i) {
					up++;
				}
			}

			if (up + down == A.length) {
				min = Math.min(min, up);
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
