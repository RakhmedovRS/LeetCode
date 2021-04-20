package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 23-Aug-20
 */
@LeetCode(id = 1563, name = "Stone Game V", url = "https://leetcode.com/problems/stone-game-v/")
public class StoneGameV
{
	public int stoneGameV(int[] stoneValue)
	{
		int[][] memo = new int[stoneValue.length][stoneValue.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		int[] prefixSum = new int[stoneValue.length + 1];
		for (int i = 1; i < prefixSum.length; i++)
		{
			prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
		}

		return stoneGameV(stoneValue, 0, stoneValue.length - 1, prefixSum, memo);
	}

	public int stoneGameV(int[] stoneValue, int left, int right, int[] prefixSum, int[][] memo)
	{
		if (left == right)
		{
			return 0;
		}

		if (left + 1 == right)
		{
			return Math.min(stoneValue[left], stoneValue[right]);
		}

		if (memo[left][right] != -1)
		{
			return memo[left][right];
		}

		int sum = 0;
		for (int i = left; i < right; i++)
		{
			int lSum = prefixSum[i + 1] - prefixSum[left];
			int rSum = prefixSum[right + 1] - prefixSum[i + 1];

			if (lSum > rSum)
			{
				sum = Math.max(sum, rSum + stoneGameV(stoneValue, i + 1, right, prefixSum, memo));
			}
			else if (lSum < rSum)
			{
				sum = Math.max(sum, lSum + stoneGameV(stoneValue, left, i, prefixSum, memo));
			}
			else
			{
				sum = Math.max(sum, Math.max(stoneGameV(stoneValue, left, i, prefixSum, memo),
					stoneGameV(stoneValue, i + 1, right, prefixSum, memo)) + lSum);
			}
		}

		memo[left][right] = sum;
		return sum;
	}
}
