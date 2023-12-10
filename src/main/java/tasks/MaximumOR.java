package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2680,
		name = "Maximum OR",
		url = "https://leetcode.com/problems/maximum-or/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumOR {
	public long maximumOr(int[] nums, int k) {
		long ans = 0;
		long[] longs = new long[nums.length];
		int[] bits = new int[64];
		for (int i = 0; i < nums.length; i++) {
			longs[i] = nums[i];
			add(bits, longs[i]);
		}


		for (int i = 0; i < longs.length; i++) {
			long prev = longs[i];
			long next = prev;
			for (int a = 0; a < k; a++) {
				next *= 2;
			}

			longs[i] = next;
			remove(bits, prev);
			add(bits, next);
			ans = Math.max(ans, calcNum(bits));
			remove(bits, next);
			add(bits, prev);
			longs[i] = prev;
		}

		return ans;
	}

	private void remove(int[] bits, long num) {
		char[] chars = Long.toBinaryString(num).toCharArray();
		for (int pos = bits.length - 1, cPos = chars.length - 1; cPos >= 0; pos--, cPos--) {
			bits[pos] -= chars[cPos] - '0';
		}
	}

	private void add(int[] bits, long num) {
		char[] chars = Long.toBinaryString(num).toCharArray();
		for (int pos = bits.length - 1, cPos = chars.length - 1; cPos >= 0; pos--, cPos--) {
			bits[pos] += chars[cPos] - '0';
		}
	}

	private long calcNum(int[] bits) {
		long ans = 0;
		for (int i = bits.length - 1, pos = 0; i >= 0; i--, pos++) {
			if (bits[i] > 0) {
				ans += Math.pow(2, pos);
			}
		}

		return ans;
	}
}
