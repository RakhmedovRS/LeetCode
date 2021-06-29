package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(
	id = 1004,
	name = "Max Consecutive Ones III",
	url = "https://leetcode.com/problems/max-consecutive-ones-iii/",
	difficulty = Difficulty.MEDIUM
)
public class MaxConsecutiveOnesIII
{
	public int longestOnes(int[] nums, int k)
	{
		int left = 0;
		int right = 0;
		int maxCountOfOnes = 0;
		while (right < nums.length)
		{
			if (nums[right++] == 0)
			{
				k--;
				while (left < right && k < 0)
				{
					if (nums[left++] == 0)
					{
						k++;
					}
				}
			}

			maxCountOfOnes = Math.max(maxCountOfOnes, right - left);
		}

		return maxCountOfOnes;
	}
}
