package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/30/2022
 */
@LeetCode(
		id = 2256,
		name = "Minimum Average Difference",
		url = "https://leetcode.com/problems/minimum-average-difference/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumAverageDifference {
	public int minimumAverageDifference(int[] nums) {
		int leftCount = 0;
		long leftSum = 0;
		int rightCount = 0;
		long rightSum = 0;

		for (int i = 0; i < nums.length; i++) {
			rightCount++;
			rightSum += nums[i];
		}

		int minIndex = 0;
		long minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			leftCount++;
			leftSum += nums[i];

			rightCount--;
			rightSum -= nums[i];

			long left = leftSum / leftCount;
			long right = rightCount == 0 ? 0 : rightSum / rightCount;
			long diff = Math.abs(left - right);
			if (diff < minDiff) {
				minDiff = diff;
				minIndex = i;
			}
		}

		return minIndex;
	}
}
