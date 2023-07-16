package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/21/2021
 */
@LeetCode(
		id = 1770,
		name = "Maximum Score from Performing Multiplication Operations",
		url = "https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumScoreFromPerformingMultiplicationOperations
{
	public int maximumScore(int[] nums, int[] multipliers)
	{
		Integer[][] memo = new Integer[1001][1001];
		return dfs(0, 0, nums.length - 1, nums, multipliers, memo);
	}

	private int dfs(int mPos, int left, int right, int[] nums, int[] multipliers, Integer[][] memo)
	{
		if (mPos == multipliers.length || left > right)
		{
			return 0;
		}

		if (memo[mPos][left] != null)
		{
			return memo[mPos][left];
		}

		int leftStep = nums[left] * multipliers[mPos] + dfs(mPos + 1, left + 1, right, nums, multipliers, memo);
		int rightStep = nums[right] * multipliers[mPos] + dfs(mPos + 1, left, right - 1, nums, multipliers, memo);

		memo[mPos][left] = Math.max(leftStep, rightStep);

		return memo[mPos][left];
	}
}
