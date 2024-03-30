package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-30
 */
@LeetCode(
		id = 3095,
		name = "Shortest Subarray With OR at Least K I",
		url = "https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/",
		difficulty = Difficulty.EASY
)
public class ShortestSubarrayWithORAtLeastKI {
	public int minimumSubarrayLength(int[] nums, int k) {
		int or = 0;
		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		int[] bits = new int[32];
		while (right < nums.length) {
			or(bits, nums[right++]);
			or = constructNum(bits);
			while (or >= k && left < right) {
				min = Math.min(min, right - left);
				removeBitsForNumber(bits, nums[left++]);
				or = constructNum(bits);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private void or(int[] bits, int num) {
		char[] chars = Integer.toBinaryString(num).toCharArray();
		for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
			bits[j] += chars[i] - '0';
		}
	}

	private void removeBitsForNumber(int[] bits, int num) {
		char[] chars = Integer.toBinaryString(num).toCharArray();
		for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
			bits[j] -= chars[i] - '0';
		}
	}

	private int constructNum(int[] bits) {
		int num = 0;
		for (int pow = 0, i = 0; i < bits.length; i++, pow++) {
			if (bits[i] > 0) {
				num += Math.pow(2, pow);
			}
		}
		return num;
	}
}