import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 14-Feb-20
 */
@LeetCode(id = 300, name = "Longest Increasing Subsequence", url = "https://leetcode.com/problems/longest-increasing-subsequence/")
public class LongestIncreasingSubsequence
{
	public int lengthOfLIS(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int[] memo = new int[nums.length];
		Arrays.fill(memo, 1);

		for (int right = 1; right < nums.length; right++)
		{
			for (int left = 0; left < right; left++)
			{
				if (nums[left] < nums[right])
				{
					memo[right] = Math.max(memo[left] + 1, memo[right]);
				}
			}
		}


		int max = 0;
		for (int value: memo)
		{
			max = Math.max(value, max);
		}

		return max;
	}
}
