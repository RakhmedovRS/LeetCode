package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(
	id = 561,
	name = "Array Partition I",
	url = "https://leetcode.com/problems/array-partition-i/",
	difficulty = Difficulty.EASY
)
public class ArrayPartitionI
{
	public int arrayPairSum(int[] nums)
	{
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2)
		{
			sum += nums[i];
		}

		return sum;
	}
}
