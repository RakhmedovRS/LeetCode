package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/24/2022
 * @rakhmedovrs$
 * @1.0$
 */

@LeetCode(
		id = 2348,
		name = "Number of Zero-Filled Subarrays",
		url = "https://leetcode.com/problems/number-of-zero-filled-subarrays/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfZeroFilledSubarrays
{
	public long zeroFilledSubarray(int[] nums)
	{
		long answer = 0;
		int right = 0;
		int count = 0;
		while (right < nums.length)
		{
			if (nums[right++] != 0)
			{
				answer += ((long) count * (count + 1) / 2);
				count = 0;
			}
			else
			{
				count++;
			}
		}

		answer += ((long) count * (count + 1) / 2);

		return answer;
	}
}
