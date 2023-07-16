package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/8/2020
 */
@LeetCode(
		id = 1646,
		name = "Get Maximum in Generated Array",
		url = "https://leetcode.com/problems/get-maximum-in-generated-array/",
		difficulty = Difficulty.EASY
)
public class GetMaximumInGeneratedArray
{
	public int getMaximumGenerated(int n)
	{
		if (n <= 1)
		{
			return n;
		}

		int max = 0;
		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			if (i % 2 == 0)
			{
				memo[i] = memo[i / 2];
			}
			else
			{
				memo[i] = memo[i / 2] + memo[i / 2 + 1];
			}

			max = Math.max(max, memo[i]);
		}

		return max;
	}
}
