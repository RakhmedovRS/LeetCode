package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2786,
		name = "Visit Array Positions to Maximize Score",
		url = "https://leetcode.com/problems/visit-array-positions-to-maximize-score/",
		difficulty = Difficulty.MEDIUM
)
public class VisitArrayPositionsToMaximizeScore {
	public long maxScore(int[] nums, int x) {
		long[] e = new long[nums.length];
		long[] o = new long[nums.length];
		long sum = 0;
		for (int i = e.length - 1; i >= 0; i--) {
			e[i] = sum;
			if (nums[i] % 2 == 0) {
				sum += nums[i];
			}
		}

		sum = 0;
		for (int i = o.length - 1; i >= 0; i--) {
			o[i] = sum;
			if (nums[i] % 2 != 0) {
				sum += nums[i];
			}
		}

		long max = 0;
		long even = 0;
		long odd = 0;
		boolean seenEven = false;
		boolean seenOdd = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				if (nums[0] % 2 != 0 && !seenEven) {
					even = odd - x;
				}

				even = Math.max(even + nums[i], odd + nums[i] - x);
				max = Math.max(max, even + e[i]);
				max = Math.max(max, even + o[i] - x);
				seenEven = true;
			}
			else {
				if (nums[0] % 2 == 0 && !seenOdd) {
					odd = even - x;
				}

				odd = Math.max(odd + nums[i], even + nums[i] - x);
				max = Math.max(max, odd + o[i]);
				max = Math.max(max, odd + e[i] - x);
				seenOdd = true;
			}
		}

		return max;
	}
}
