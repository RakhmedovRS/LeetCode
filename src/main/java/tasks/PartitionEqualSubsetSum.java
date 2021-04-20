package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 03-Aug-20
 */
@LeetCode(
	id = 416,
	name = "Partition Equal Subset Sum",
	url = "https://leetcode.com/problems/partition-equal-subset-sum/",
	difficulty = Difficulty.MEDIUM
)
public class PartitionEqualSubsetSum
{
	public boolean canPartition(int[] nums)
	{
		int sum = 0;
		Arrays.sort(nums);
		for (int num : nums)
		{
			sum += num;
		}

		if (sum % 2 != 0)
		{
			return false;
		}

		return dfs(0, sum / 2, nums, new Boolean[201][10001]);
	}

	private boolean dfs(int pos, int sum, int[] nums, Boolean[][] memo)
	{
		if (sum == 0)
		{
			return true;
		}

		if (pos == nums.length || sum < 0)
		{
			return false;
		}

		if (memo[pos][sum] != null)
		{
			return memo[pos][sum];
		}

		memo[pos][sum] = dfs(pos + 1, sum - nums[pos], nums, memo) || dfs(pos + 1, sum, nums, memo);

		return memo[pos][sum];
	}
}
