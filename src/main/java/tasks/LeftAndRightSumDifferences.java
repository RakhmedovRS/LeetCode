package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/26/2023
 */
@LeetCode(
		id = 2574,
		name = "Left and Right Sum Differences",
		url = "https://leetcode.com/problems/left-and-right-sum-differences/",
		difficulty = Difficulty.EASY
)
public class LeftAndRightSumDifferences {
	public int[] leftRigthDifference(int[] nums) {
		long[] right = new long[nums.length];
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] += right[i + 1] + nums[i + 1];
		}

		long sum = 0;
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			answer[i] = Math.abs((int) (sum - right[i]));
			sum += nums[i];
		}

		return answer;
	}
}
