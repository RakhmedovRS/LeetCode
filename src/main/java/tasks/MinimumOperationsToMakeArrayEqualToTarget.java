package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-21
 */
@LeetCode(
		id = 3229,
		name = "Minimum Operations to Make Array Equal to Target",
		url = "https://leetcode.com/problems/minimum-operations-to-make-array-equal-to-target/description/",
		difficulty = Difficulty.HARD
)
public class MinimumOperationsToMakeArrayEqualToTarget {
	public long minimumOperations(int[] nums, int[] target) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = target[i] - nums[i];
		}

		boolean seenNonZero = true;
		long ops = 0;
		Integer step = null;
		int start = 0;
		while (seenNonZero) {
			seenNonZero = false;
			Boolean increment = null;
			for (int i = 0; i < res.length; i++) {
				if (res[i] > 0) {
					seenNonZero = true;
					if (increment != null && !increment) {
						update(res, start, i, step);
						ops += Math.abs(step);
						start = i;
						step = null;
					}
					step = step == null ? res[i] : Math.min(step, res[i]);
					increment = true;
				} else if (res[i] < 0) {
					seenNonZero = true;
					if (increment != null && increment) {
						update(res, start, i, step);
						ops += Math.abs(step);
						start = i;
						step = null;
					}
					step = step == null ? res[i] : Math.max(step, res[i]);
					increment = false;
				} else {
					if (increment != null) {
						update(res, start, i, step);
						ops += Math.abs(step);
					}

					increment = null;
					step = null;
					start = i + 1;
					while (i + 1 < nums.length && res[i + 1] == 0) {
						i++;
						start = i + 1;
					}
				}
			}

			if (seenNonZero && increment != null) {
				update(res, start, nums.length, step);
				ops += Math.abs(step);
				step = null;
			}

			start = 0;
		}
		return ops;
	}

	private void update(int[] res, int start, int end, int step) {
		for (; start < end; start++) {
			res[start] -= step;
		}
	}
}