package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/16/2020
 */
@LeetCode(
	id = 327,
	name = "Count of Range Sum",
	url = "https://leetcode.com/problems/count-of-range-sum/",
	difficulty = Difficulty.HARD
)
public class CountOfRangeSum
{
	class Solution
	{
		public int countRangeSum(int[] nums, int lower, int upper)
		{
			long[] prefix = new long[nums.length + 1];
			for (int i = 1; i < prefix.length; i++)
			{
				prefix[i] = prefix[i - 1] + nums[i - 1];
			}

			int count = 0;
			long sum;
			for (int i = 1; i < prefix.length; i++)
			{
				for (int j = 1; j <= i; j++)
				{
					sum = prefix[i] - prefix[j - 1];
					if (lower <= sum && sum <= upper)
					{
						count++;
					}
				}
			}

			return count;
		}
	}
}
