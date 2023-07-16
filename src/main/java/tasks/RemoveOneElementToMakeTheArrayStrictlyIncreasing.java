package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/26/2021
 */
@LeetCode(
		id = 1909,
		name = "Remove One Element to Make the Array Strictly Increasing",
		url = "https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/",
		difficulty = Difficulty.EASY
)
public class RemoveOneElementToMakeTheArrayStrictlyIncreasing
{
	public boolean canBeIncreasing(int[] nums)
	{
		outer:
		for (int i = 0; i < nums.length; i++)
		{
			Integer prev = null;
			for (int j = 0; j < nums.length; j++)
			{
				if (i == j)
				{
					continue;
				}

				if (prev == null)
				{
					prev = nums[j];
				}
				else
				{
					if (prev >= nums[j])
					{
						continue outer;
					}
					prev = nums[j];
				}
			}

			return true;
		}

		return false;
	}
}
