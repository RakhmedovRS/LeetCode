package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
@LeetCode(
	id = 485,
	name = "Max Consecutive Ones",
	url = "https://leetcode.com/problems/max-consecutive-ones/",
	difficulty = Difficulty.EASY
)
public class MaxConsecutiveOnes
{
	public int findMaxConsecutiveOnes(int[] nums)
	{
		int max = Integer.MIN_VALUE;
		int i = 0;
		int counter = 0;
		for (; i < nums.length; i++)
		{
			if (nums[i] == 1)
			{
				counter++;
			}
			else
			{
				max = Math.max(max, counter);
				counter = 0;
			}

			if (i == nums.length - 1)
			{
				max = Math.max(max, counter);
			}
		}
		return max;
	}
}
