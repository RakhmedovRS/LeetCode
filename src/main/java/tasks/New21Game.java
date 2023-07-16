package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/16/2020
 */
@LeetCode(
		id = 837,
		name = "New 21 Game",
		url = "https://leetcode.com/problems/new-21-game/",
		difficulty = Difficulty.MEDIUM
)
public class New21Game
{
	public double new21Game(int N, int K, int W)
	{
		if (K == 0)
		{
			return 1D;
		}

		double[] dp = new double[N + 1];
		dp[0] = 1;
		double sum = 0;
		for (int i = 1; i < dp.length; i++)
		{
			if (i - 1 < K)
			{
				sum += dp[i - 1];
			}

			if (i - 1 - W >= 0)
			{
				sum -= dp[i - 1 - W];
			}

			dp[i] = sum / W;
		}

		double result = 0D;
		for (int i = K; i <= N; i++)
		{
			result += dp[i];
		}

		return result;
	}
}
