package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 3/13/2023
 */
@LeetCode(
		id = 2587,
		name = "Rearrange Array to Maximize Prefix Score",
		url = "https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/",
		difficulty = Difficulty.MEDIUM
)
public class RearrangeArrayToMaximizePrefixScore
{
	public int maxScore(int[] nums)
	{
		Arrays.sort(nums);

		int c = 0;
		long sum = 0;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			sum += nums[i];
			if (sum > 0)
			{
				c++;
			}
		}

		return c;
	}
}
