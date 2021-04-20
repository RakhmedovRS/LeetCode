package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 19-Jul-20
 */
@LeetCode(id = 375, name = "Guess Number Higher or Lower II", url = "https://leetcode.com/problems/guess-number-higher-or-lower-ii/")
public class GuessNumberHigherOrLowerII
{
	public int getMoneyAmount(int n)
	{
		int[][] dp = new int[n + 1][n + 1];
		for (int[] row : dp)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		return solve(1, n, dp);
	}

	private int solve(int left, int right, int[][] dp)
	{
		if (left >= right)
		{
			return 0;
		}

		if (dp[left][right] != Integer.MAX_VALUE)
		{
			return dp[left][right];
		}

		for (int i = left; i <= right; i++)
		{
			dp[left][right] = Math.min(dp[left][right], Math.max(i + solve(left, i - 1, dp), i + solve(i + 1, right, dp)));
		}

		return dp[left][right];
	}
}
