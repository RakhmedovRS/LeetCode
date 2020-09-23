import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Sep-20
 */
@LeetCode(id = 673, name = "Number of Longest Increasing Subsequence", url = "https://leetcode.com/problems/number-of-longest-increasing-subsequence/")
public class NumberOfLongestIncreasingSubsequence
{
	public int findNumberOfLIS(int[] nums)
	{
		int[] lengths = new int[nums.length];
		int[] counts = new int[nums.length];

		int maxLength = 1;
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			lengths[i] = 1;
			counts[i] = 1;
			for (int j = 0; j < i; j++)
			{
				if (nums[i] > nums[j])
				{
					if (lengths[i] == lengths[j] + 1)
					{
						counts[i] += counts[j];
					}
					else if (lengths[i] < lengths[j] + 1)
					{
						lengths[i] = lengths[j] + 1;
						counts[i] = counts[j];
					}
				}
			}

			if (maxLength == lengths[i])
			{
				count += counts[i];
			}
			else if (maxLength < lengths[i])
			{
				maxLength = lengths[i];
				count = counts[i];
			}
		}

		return count;
	}
}
