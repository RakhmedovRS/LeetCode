import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 25-May-20
 */
@LeetCode(id = 698, name = "Partition to K Equal Sum Subsets", url = "https://leetcode.com/problems/partition-to-k-equal-sum-subsets/")
public class PartitionToKEqualSumSubsets
{
	public boolean canPartitionKSubsets(int[] nums, int k)
	{
		if (k == 0)
		{
			return false;
		}

		int sum = Arrays.stream(nums).sum();
		if (sum % k != 0)
		{
			return false;
		}

		return canPartitionKSubsets(0, nums, new boolean[nums.length], k, 0, sum / k);
	}

	private boolean canPartitionKSubsets(int start, int[] arr, boolean[] used,
	                                     int k, int currentSum, int targetSum)
	{
		if (k == 0)
		{
			return true;
		}

		if (currentSum == targetSum)
		{
			return canPartitionKSubsets(0, arr, used, k - 1, 0, targetSum);
		}

		for (int i = start; i < arr.length; i++)
		{
			if (!used[i] && currentSum + arr[i] <= targetSum)
			{
				used[i] = true;
				if (canPartitionKSubsets(i + 1, arr, used, k, currentSum + arr[i], targetSum))
				{
					return true;
				}
				used[i] = false;
			}
		}
		return false;
	}
}
