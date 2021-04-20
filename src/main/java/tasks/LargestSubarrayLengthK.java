package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/1/2021
 */
@LeetCode(
	id = 1708,
	name = "Largest Subarray Length K",
	url = "https://leetcode.com/problems/largest-subarray-length-k/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class LargestSubarrayLengthK
{
	public int[] largestSubarray(int[] nums, int k)
	{
		int maxPos = 0;
		for (int i = 0; i <= nums.length - k; i++)
		{
			if (nums[i] > nums[maxPos])
			{
				maxPos = i;
			}
		}

		int[] answer = new int[k];
		for (int i = 0; i < k; i++)
		{
			answer[i] = nums[maxPos++];
		}

		return answer;
	}
}
