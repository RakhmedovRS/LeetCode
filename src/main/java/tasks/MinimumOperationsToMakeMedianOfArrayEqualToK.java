package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-06
 */
@LeetCode(
		id = 3107,
		name = "Minimum Operations to Make Median of Array Equal to K",
		url = "https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeMedianOfArrayEqualToK {
	public long minOperationsToMakeMedianK(int[] nums, int k) {
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		long ans = 0L;
		int middle;
		int startPos;
		boolean movingRight;
		if (nums.length % 2 == 0) {
			middle = nums[nums.length / 2];
			if (middle <= k) {
				movingRight = true;
				startPos = nums.length / 2;
			} else {
				movingRight = false;
				startPos = nums.length / 2;
			}
		} else {
			middle = nums[nums.length / 2];
			if (middle <= k) {
				movingRight = true;
				startPos = nums.length / 2;
			} else {
				movingRight = false;
				startPos = nums.length / 2;
			}
		}

		if (movingRight) {
			int maxSoFar = k;
			while (startPos < nums.length) {
				maxSoFar = Math.max(maxSoFar, nums[startPos]);
				ans += maxSoFar - nums[startPos++];
			}
		} else {
			int minSoFar = k;
			while (startPos >= 0) {
				minSoFar = Math.min(minSoFar, nums[startPos]);
				ans += nums[startPos--] - minSoFar;
			}
		}

		return ans;
	}
}