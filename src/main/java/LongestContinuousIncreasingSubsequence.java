import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Feb-20
 */
@LeetCode(id = 674, name = "Longest Continuous Increasing Subsequence", url = "https://leetcode.com/problems/longest-continuous-increasing-subsequence/")
public class LongestContinuousIncreasingSubsequence
{
	public int findLengthOfLCIS(int[] nums)
	{
		int max = 0;
		if (nums == null || nums.length == 0)
		{
			return max;
		}

		int elements = 0;
		int prev = Integer.MIN_VALUE;
		for (int num : nums)
		{
			if (num > prev)
			{
				elements++;
			}
			else
			{
				elements = 1;
			}
			max = Math.max(max, elements);
			prev = num;
		}

		return max;
	}
}
