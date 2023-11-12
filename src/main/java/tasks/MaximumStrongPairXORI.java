package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/11/2023
 */
@LeetCode(
		id = 2932,
		name = "Maximum Strong Pair XOR I",
		url = "https://leetcode.com/problems/maximum-strong-pair-xor-i/",
		difficulty = Difficulty.EASY
)
public class MaximumStrongPairXORI
{
	public int maximumStrongPairXor(int[] nums)
	{
		int max = 0;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i; j < nums.length; j++)
			{
				if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j]))
				{
					max = Math.max(max, nums[i] ^ nums[j]);
				}
			}
		}

		return max;
	}
}
