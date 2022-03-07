package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(
	id = 1130,
	name = "Minimum Cost Tree From Leaf Values",
	url = "https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumCostTreeFromLeafValues
{
	public int mctFromLeafValues(int[] arr)
	{
		int[][] memo = new int[arr.length][arr.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return dp(arr, 0, arr.length - 1, memo);
	}

	private int dp(int[] arr, int left, int right, int[][] memo)
	{
		if (left >= right)
		{
			return 0;
		}

		if (memo[left][right] != -1)
		{
			return memo[left][right];
		}

		int min = Integer.MAX_VALUE;
		for (int i = left; i < right; i++)
		{
			int l = dp(arr, left, i, memo);
			int r = dp(arr, i + 1, right, memo);
			int maxLeft = 0;
			int maxRight = 0;
			for (int pos = left; pos <= i; pos++)
			{
				maxLeft = Math.max(maxLeft, arr[pos]);
			}
			for (int pos = i + 1; pos <= right; pos++)
			{
				maxRight = Math.max(maxRight, arr[pos]);
			}

			min = Math.min(min, l + r + maxLeft * maxRight);
		}

		memo[left][right] = min;
		return min;
	}
}
