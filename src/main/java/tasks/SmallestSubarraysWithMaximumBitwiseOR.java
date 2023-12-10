package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 9/21/2022
 */
@LeetCode(
		id = 2411,
		name = "Smallest Subarrays With Maximum Bitwise OR",
		url = "https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/",
		difficulty = Difficulty.MEDIUM
)
public class SmallestSubarraysWithMaximumBitwiseOR {
	public int[] smallestSubarrays(int[] nums) {
		int[][] memoRightToLeft = new int[nums.length][31];
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i != nums.length - 1) {
				memoRightToLeft[i] = Arrays.copyOf(memoRightToLeft[i + 1], memoRightToLeft[i + 1].length);
			}

			String bits = Integer.toBinaryString(nums[i]);
			for (int j = bits.length() - 1, pos = 30; j >= 0; j--, pos--) {
				if (bits.charAt(j) == '1') {
					memoRightToLeft[i][pos] = i;
				}
			}
		}

		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int pos : memoRightToLeft[i]) {
				answer[i] = Math.max(answer[i], Math.max(1, 1 + pos - i));
			}
		}

		return answer;
	}
}
