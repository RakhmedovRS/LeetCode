package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2784,
		name = "Check if Array is Good",
		url = "https://leetcode.com/problems/check-if-array-is-good/",
		difficulty = Difficulty.EASY
)
public class CheckIfArrayIsGood
{
	public boolean isGood(int[] nums)
	{
		if (nums.length < 2)
		{
			return false;
		}

		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 2; i++)
		{
			if (nums[i - 1] + 1 != nums[i])
			{
				return false;
			}
		}

		return nums[nums.length - 2] == nums[nums.length - 1] && nums[nums.length - 1] == nums.length - 1;
	}
}
