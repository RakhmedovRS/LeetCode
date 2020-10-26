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

		return canPartitionReq(0, nums, sum, new Boolean[nums.length][sum + 1]);
	}

	private boolean canPartitionReq(int pos, int[] nums, int totalSum, Boolean[][] memo)
	{
		if (totalSum == 0)
		{
			return true;
		}

		if (pos == nums.length || totalSum < 0)
		{
			return false;
		}

		if (memo[pos][totalSum] != null)
		{
			return memo[pos][totalSum];
		}

		memo[pos][totalSum] = canPartitionReq(pos + 1, nums, totalSum, memo) ||
			canPartitionReq(pos + 1, nums, totalSum - nums[pos], memo);

		return memo[pos][totalSum];
	}
}
