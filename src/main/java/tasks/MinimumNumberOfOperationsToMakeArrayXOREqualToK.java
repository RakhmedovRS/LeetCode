package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/6/2024
 */
@LeetCode(
		id = 2997,
		name = "Minimum Number of Operations to Make Array XOR Equal to K",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
	public int minOperations(int[] nums, int k) {
		int[] arrayBits = new int[32];
		for (int num : nums) {
			String nBits = Integer.toBinaryString(num);
			for (int i = nBits.length() - 1, pos = 31; i >= 0; i--, pos--) {
				arrayBits[pos] += nBits.charAt(i) - '0';
				arrayBits[pos] %= 2;
			}
		}

		int[] kNumBits = new int[32];
		String kBits = Integer.toBinaryString(k);
		int flips = 0;
		for (int i = kBits.length() - 1, pos = 31; i >= 0; i--, pos--) {
			kNumBits[pos] += kBits.charAt(i) - '0';
		}

		for (int i = 0; i < 32; i++) {
			flips += Math.abs(kNumBits[i] - arrayBits[i]);
		}

		return flips;
	}
}
