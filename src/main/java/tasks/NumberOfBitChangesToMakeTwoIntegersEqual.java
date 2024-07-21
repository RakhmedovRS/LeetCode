package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-21
 */
@LeetCode(
		id = 3226,
		name = "Number of Bit Changes to Make Two Integers Equal",
		url = "https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/",
		difficulty = Difficulty.EASY
)
public class NumberOfBitChangesToMakeTwoIntegersEqual {
	public int minChanges(int n, int k) {
		if (n == k) {
			return 0;
		}

		int[] N = getBits(n);
		int[] K = getBits(k);

		int changes = 0;
		for (int i = 0; i < N.length; i++) {
			if (N[i] != K[i]) {
				if (N[i] == 1) {
					changes++;
				} else {
					return -1;
				}
			}
		}
		return changes;
	}

	private int[] getBits(int n) {
		int[] bits = new int[32];
		int pos = 0;
		while (pos < 32) {
			bits[pos++] = n % 2;
			n /= 2;
		}
		return bits;
	}
}