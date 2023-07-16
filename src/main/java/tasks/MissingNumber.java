package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(
		id = 268,
		name = "Missing Number",
		url = "https://leetcode.com/problems/missing-number/",
		difficulty = Difficulty.EASY
)
public class MissingNumber
{
	public int missingNumber(int[] nums)
	{
		int temp;
		for (int i = 0; i < nums.length; i++)
		{
			while (nums[i] != i && nums[i] < nums.length && nums[nums[i]] != nums[i])
			{
				temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != i)
			{
				return i;
			}
		}

		return nums.length;
	}
}
