package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(
		id = 650,
		name = "2 Keys Keyboard",
		url = "https://leetcode.com/problems/2-keys-keyboard/",
		difficulty = Difficulty.MEDIUM
)
public class TwoKeysKeyboard
{
	public int minSteps(int n)
	{
		if (n == 1)
		{
			return 0;
		}

		Integer[] memo = new Integer[n + 1];
		return dfs(n, memo);
	}

	private int dfs(int n, Integer[] memo)
	{
		if (n == 1)
		{
			return 0;
		}

		if (memo[n] != null)
		{
			return memo[n];
		}

		memo[n] = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++)
		{
			if (n % i == 0)
			{
				memo[n] = Math.min(memo[n], dfs(i, memo) + n / i);
			}
		}

		return memo[n];
	}
}
