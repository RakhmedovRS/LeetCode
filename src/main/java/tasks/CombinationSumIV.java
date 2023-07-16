package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(
		id = 377,
		name = "Combination Sum IV",
		url = "https://leetcode.com/problems/combination-sum-iv/",
		difficulty = Difficulty.MEDIUM
)
public class CombinationSumIV
{
	public int combinationSum4(int[] nums, int target)
	{
		int[] memo = new int[1001];
		Arrays.fill(memo, -1);
		Arrays.sort(nums);
		return dfs(target, nums, memo);
	}

	private int dfs(int target, int[] nums, int[] memo)
	{
		if (target < 0)
		{
			return -1;
		}

		if (target == 0)
		{
			return 1;
		}

		if (memo[target] != -1)
		{
			return memo[target];
		}

		int use;
		memo[target] = 0;
		for (int num : nums)
		{
			use = dfs(target - num, nums, memo);
			if (use != -1)
			{
				memo[target] += use;
			}
		}

		return memo[target];
	}

	public static void main(String[] args)
	{
		System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
		System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 32));
	}
}
