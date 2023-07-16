package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/28/2021
 */
@LeetCode(
		id = 2090,
		name = "K Radius Subarray Averages",
		url = "https://leetcode.com/problems/k-radius-subarray-averages/",
		difficulty = Difficulty.MEDIUM
)
public class KRadiusSubarrayAverages
{
	public int[] getAverages(int[] nums, int k)
	{
		int[] answer = new int[nums.length];
		long[] memo = new long[nums.length];
		for (int i = 0; i < memo.length; i++)
		{
			memo[i] = nums[i];
		}

		for (int i = 1; i < nums.length; i++)
		{
			memo[i] += memo[i - 1];
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (i - k >= 0 && i + k < memo.length)
			{
				long sum = memo[i + k] - (i - k - 1 >= 0 ? memo[i - k - 1] : 0);
				answer[i] = (int) (sum / (k * 2 + 1));
			}
			else
			{
				answer[i] = -1;
			}
		}

		return answer;
	}
}
