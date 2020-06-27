import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
@LeetCode(id = 279, name = "Perfect Squares", url = "https://leetcode.com/problems/perfect-squares/")
public class PerfectSquares
{
	public int numSquares(int n)
	{
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++)
		{
			for (int val = 1; val * val <= i; val++)
			{
				dp[i] = Math.min(dp[i], 1 + dp[i - val * val]);
			}
		}

		return dp[n];
	}

	public static void main(String[] args)
	{
		System.out.println(new PerfectSquares().numSquares(13));
	}
}
