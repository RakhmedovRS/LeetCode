package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/3/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2134,
		name = "Minimum Swaps to Group All 1's Together II",
		url = "https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumSwapsToGroupAllOnesTogetherII
{
	public int minSwaps(int[] nums)
	{
		int[] memo = new int[nums.length * 2];
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			memo[i] = nums[i];
			memo[i + nums.length] = nums[i];
			count += nums[i];
		}

		int min = nums.length;

		if (count == 0)
		{
			return 0;
		}

		int currentCount = 0;
		for (int left = 0, right = 0; right < memo.length; right++)
		{
			currentCount += memo[right];
			if (right >= count)
			{
				currentCount -= memo[left++];
			}

			min = Math.min(min, count - currentCount);
		}

		return min;
	}
}
