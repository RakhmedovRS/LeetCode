package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 8/6/2023
 */
@LeetCode(
		id = 2811,
		name = "Check if it is Possible to Split Array",
		url = "https://leetcode.com/problems/check-if-it-is-possible-to-split-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfItIsPossibleToSplitArray {
	public boolean canSplitArray(List<Integer> input, int m) {
		if (input.size() < 3) {
			return true;
		}

		Boolean[][] memo = new Boolean[input.size()][input.size()];
		int[] nums = new int[input.size()];
		int[] sum = new int[input.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.get(i);
			sum[i] = input.get(i);
			if (i > 0) {
				sum[i] += sum[i - 1];
			}
		}

		return canSplitArray(nums, sum, m, 0, nums.length - 1, memo);
	}

	public boolean canSplitArray(int[] nums, int[] sum, int m, int left, int right, Boolean[][] memo) {
		if (left >= right) {
			return true;
		}

		if (memo[left][right] != null) {
			return memo[left][right];
		}

		int s = s(sum, left, right);

		if (s < m) {
			return false;
		}

		memo[left][right] = canSplitArray(nums, sum, m, left + 1, right, memo) || canSplitArray(nums, sum, m, left, right - 1, memo);
		return memo[left][right];
	}

	private int s(int[] sum, int left, int right) {
		int l = left == 0 ? 0 : sum[left - 1];
		return sum[right] - l;
	}
}
