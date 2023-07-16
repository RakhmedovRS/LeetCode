package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 18-Aug-20
 */
@LeetCode(
		id = 486,
		name = "Predict the Winner",
		url = "https://leetcode.com/problems/predict-the-winner/",
		difficulty = Difficulty.MEDIUM
)
public class PredictTheWinner
{
	public boolean PredictTheWinner(int[] nums)
	{
		int[][] memo = new int[nums.length][nums.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		int totalSum = 0;
		for (int num : nums)
		{
			totalSum += num;
		}

		int firstPlayerResult = PredictTheWinner(nums, 0, nums.length - 1, memo);
		return firstPlayerResult >= totalSum - firstPlayerResult;
	}

	private int PredictTheWinner(int[] nums, int left, int right, int[][] memo)
	{
		if (left == right)
		{
			return nums[left];
		}

		if (left > right)
		{
			return 0;
		}

		if (memo[left][right] != -1)
		{
			return memo[left][right];
		}

		int leftStep = nums[left] + Math.min(PredictTheWinner(nums, left + 2, right, memo), PredictTheWinner(nums, left + 1, right - 1, memo));
		int rightStep = nums[right] + Math.min(PredictTheWinner(nums, left, right - 2, memo), PredictTheWinner(nums, left + 1, right - 1, memo));

		return memo[left][right] = Math.max(leftStep, rightStep);
	}
}
