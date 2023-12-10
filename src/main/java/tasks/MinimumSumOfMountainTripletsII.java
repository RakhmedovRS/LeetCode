package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/21/2023
 */
@LeetCode(
		id = 2909,
		name = "Minimum Sum of Mountain Triplets II",
		url = "https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumSumOfMountainTripletsII {
	public int minimumSum(int[] nums) {
		int min = Integer.MAX_VALUE;
		int[] ltr = new int[nums.length];
		int[] rtl = new int[nums.length];
		int curr = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			curr = Math.min(curr, nums[i]);
			ltr[i] = curr;
		}

		curr = Integer.MAX_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			curr = Math.min(curr, nums[i]);
			rtl[i] = curr;
		}

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > ltr[i - 1] && nums[i] > rtl[i + 1]) {
				min = Math.min(min, ltr[i - 1] + nums[i] + rtl[i + 1]);
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
