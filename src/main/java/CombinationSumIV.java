import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(id = 377, name = "Combination Sum IV", url = "https://leetcode.com/problems/combination-sum-iv/")
public class CombinationSumIV
{
	public int combinationSum4(int[] nums, int target)
	{
		int[] memo = new int[target + 1];
		Arrays.fill(memo, -1);

		return helper(nums, target, memo);
	}

	public int helper(int[] nums, int target, int[] memo)
	{
		if (target == 0)
		{
			return 1;
		}

		if (target < 0)
		{
			return 0;
		}

		if (memo[target] != -1)
		{
			return memo[target];
		}

		int res = 0;
		for (int num : nums)
		{
			res += helper(nums, target - num, memo);
		}

		memo[target] = res;

		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
		System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 32));
	}
}
