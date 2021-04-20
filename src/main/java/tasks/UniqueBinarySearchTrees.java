package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/3/2020
 */
@LeetCode(id = 96, name = "Unique Binary Search Trees", url = "")
public class UniqueBinarySearchTrees
{
	public int numTrees(int n)
	{
		return dfs(n, new Integer[n + 1]);
	}

	private int dfs(int n, Integer[] memo)
	{
		if (n <= 1)
		{
			return 1;
		}

		if (memo[n] != null)
		{
			return memo[n];
		}

		memo[n] = 0;
		for (int i = 1; i <= n; i++)
		{
			memo[n] += (dfs(i - 1, memo) * dfs(n - i, memo));
		}

		return memo[n];
	}
}
