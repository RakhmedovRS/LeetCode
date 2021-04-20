package tasks;

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
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums)
		{
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0)
			{
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len)
			{
				len++;
			}
		}
		return len;
	}

	public int lengthOfLIS1(int[] nums)
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
					memo[right] = Math.max(memo[right], memo[left] + 1);
				}
			}
		}

		int max = 0;
		for (int count : memo)
		{
			if (count > max)
			{
				max = count;
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{}));
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1}));
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 0, 3, 4, 4}));
	}
}
