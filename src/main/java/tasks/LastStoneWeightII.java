package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 18-Aug-20
 */
@LeetCode(id = 1049, name = "Last Stone Weight II", url = "https://leetcode.com/problems/last-stone-weight-ii/")
public class LastStoneWeightII
{
	public int lastStoneWeightII(int[] stones)
	{
		int sum = 0;
		for (int stone : stones)
		{
			sum += stone;
		}

		Integer[][] memo = new Integer[sum + 1][sum + 1];
		return dfs(0, stones, 0, sum, memo);
	}

	private int dfs(int pos, int[] stones, int leftSum, int rightSum, Integer[][] memo)
	{
		if (pos == stones.length)
		{
			return Math.abs(leftSum - rightSum);
		}

		if (memo[leftSum][rightSum] != null)
		{
			return memo[leftSum][rightSum];
		}

		memo[leftSum][rightSum] = Math.min(dfs(pos + 1, stones, leftSum + stones[pos], rightSum - stones[pos], memo),
				dfs(pos + 1, stones, leftSum, rightSum, memo)
		);

		return memo[leftSum][rightSum];
	}
}
