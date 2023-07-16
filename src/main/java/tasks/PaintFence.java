package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/18/2021
 */
@LeetCode(
		id = 276,
		name = "Paint Fence",
		url = "https://leetcode.com/problems/paint-fence/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class PaintFence
{
	public int numWays(int n, int k)
	{
		if (n == 0 || k == 0)
		{
			return 0;
		}

		if (n == 1)
		{
			return k;
		}
		else if (n == 2)
		{
			return k * k;
		}

		int[] memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = k;
		memo[2] = k * k;
		for (int i = 3; i <= n; i++)
		{
			memo[i] = (memo[i - 2] + memo[i - 1]) * (k - 1);
		}

		return memo[n];
	}
}
