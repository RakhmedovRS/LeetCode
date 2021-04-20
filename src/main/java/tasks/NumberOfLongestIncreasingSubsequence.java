package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 23-Sep-20
 */
@LeetCode(id = 673, name = "Number of Longest Increasing Subsequence", url = "https://leetcode.com/problems/number-of-longest-increasing-subsequence/")
public class NumberOfLongestIncreasingSubsequence
{
	public int findNumberOfLIS(int[] nums)
	{
		int maxLength = 1;
		int maxCount = 0;
		int[] length = new int[nums.length];
		int[] count = new int[nums.length];
		Arrays.fill(length, 1);
		Arrays.fill(count, 1);
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (nums[j] < nums[i])
				{
					if (length[j] + 1 == length[i])
					{
						count[i] += count[j];
					}
					else if (length[j] + 1 > length[i])
					{
						length[i] = length[j] + 1;
						count[i] = count[j];
					}
				}
			}

			if (length[i] > maxLength)
			{
				maxLength = length[i];
				maxCount = count[i];
			}
			else if (length[i] == maxLength)
			{
				maxCount += count[i];
			}

		}

		return maxCount;
	}
}
