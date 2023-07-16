package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(
		id = 665,
		name = "Non-decreasing Array",
		url = "https://leetcode.com/problems/non-decreasing-array/",
		difficulty = Difficulty.MEDIUM
)
public class NonDecreasingArray
{
	public boolean checkPossibility(int[] nums)
	{
		Integer miss = null;
		for (int i = 0; i < nums.length - 1; i++)
		{
			if (nums[i] > nums[i + 1])
			{
				if (miss != null)
				{
					return false;
				}
				miss = i;
			}
		}

		return miss == null || miss == 0 || miss == nums.length - 2 || nums[miss - 1] <= nums[miss + 1] || nums[miss] <= nums[miss + 2];
	}
}
