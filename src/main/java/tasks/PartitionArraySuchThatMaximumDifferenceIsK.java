package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 6/13/2022
 */
@LeetCode(
	id = 2294,
	name = "Partition Array Such That Maximum Difference Is K",
	url = "https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/",
	difficulty = Difficulty.MEDIUM
)
public class PartitionArraySuchThatMaximumDifferenceIsK
{
	public int partitionArray(int[] nums, int k)
	{
		Arrays.sort(nums);
		int min = nums[0];
		int max = nums[0];
		int count = 1;
		for (int i = 0; i < nums.length; i++)
		{
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);

			if (max - min > k)
			{
				count++;
				min = nums[i];
				max = nums[i];
			}
		}

		return count;
	}
}
