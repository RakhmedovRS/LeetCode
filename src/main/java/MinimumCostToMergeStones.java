import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/23/2020
 */
@LeetCode(id = 1000, name = "Minimum Cost to Merge Stones", url = "https://leetcode.com/problems/minimum-cost-to-merge-stones/")
public class MinimumCostToMergeStones
{
	public int mergeStones(int[] stones, int K)
	{
		if (stones.length == 1)
		{
			return 0;
		}

		int[] prefixSum = new int[stones.length + 1];
		for (int i = 1; i < prefixSum.length; i++)
		{
			prefixSum[i] += prefixSum[i - 1] + stones[i - 1];
		}

		Integer[][][] memo = new Integer[stones.length + 1][stones.length + 1][K + 1];
		int res = dfs(1, prefixSum.length - 1, 1, K, prefixSum, memo);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private int dfs(int i, int j, int piles, int K, int[] prefixSum, Integer[][][] memo)
	{
		if (memo[i][j][piles] != null)
		{
			return memo[i][j][piles];
		}

		if (j - i + 1 < piles)
		{
			return Integer.MAX_VALUE;
		}

		if (i == j)
		{
			return piles == 1 ? 0 : Integer.MAX_VALUE;
		}

		int cost;
		if (piles == 1)
		{
			memo[i][j][piles] = Integer.MAX_VALUE;
			cost = dfs(i, j, K, K, prefixSum, memo);
			if (cost != Integer.MAX_VALUE)
			{
				memo[i][j][piles] = cost + prefixSum[j] - prefixSum[i - 1];
			}

			return memo[i][j][piles];
		}

		cost = Integer.MAX_VALUE;
		int leftCost;
		int rightCost;
		for (int pos = i; pos < j; pos++)
		{
			leftCost = dfs(i, pos, piles - 1, K, prefixSum, memo);
			if (leftCost == Integer.MAX_VALUE)
			{
				continue;
			}

			rightCost = dfs(pos + 1, j, 1, K, prefixSum, memo);
			if (rightCost == Integer.MAX_VALUE)
			{
				continue;
			}

			cost = Math.min(cost, leftCost + rightCost);
		}

		return memo[i][j][piles] = cost;
	}
}
