package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

@LeetCode(
		id = 2708,
		name = "Maximum Strength of a Group",
		url = "https://leetcode.com/problems/maximum-strength-of-a-group/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumStrengthOfGroup {
	public long maxStrength(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		int neg = 0;
		Long res = null;
		while (neg < nums.length && nums[neg] < 0) {
			if (neg + 1 < nums.length && nums[neg + 1] < 0) {
				if (res == null) {
					res = 1L;
				}
				res *= nums[neg];
				res *= nums[neg + 1];
				neg += 2;
			}
			else {
				break;
			}
		}

		for (int num : nums) {
			if (num > 0) {
				if (res == null) {
					res = 1L;
				}
				res *= num;
			}
		}

		if (res == null) {
			return 0;
		}

		return res;
	}
}
