import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Aug-20
 */
@LeetCode(id = 416, name = "Partition Equal Subset Sum", url = "https://leetcode.com/problems/partition-equal-subset-sum/")
public class PartitionEqualSubsetSum
{
	public boolean canPartition(int[] nums)
	{
		if (nums.length < 2)
		{
			return false;
		}

		int sum = 0;
		for (int num : nums)
		{
			sum += num;
		}

		if (sum % 2 != 0)
		{
			return false;
		}

		sum /= 2;
		Boolean[][] memo = new Boolean[nums.length][sum + 1];
		return dfs(nums, 0, sum, memo);
	}

	private boolean dfs(int[] nums, int pos, int target, Boolean[][] memo)
	{
		if (target == 0)
		{
			return true;
		}

		if (pos == nums.length || target < 0)
		{
			return false;
		}

		if (memo[pos][target] != null)
		{
			return memo[pos][target];
		}

		memo[pos][target] = dfs(nums, pos + 1, target - nums[pos], memo) || dfs(nums, pos + 1, target, memo);

		return memo[pos][target];
	}
}
