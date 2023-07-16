package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2/9/2023
 */
@LeetCode(
		id = 2560,
		name = "House Robber IV",
		url = "https://leetcode.com/problems/house-robber-iv/",
		difficulty = Difficulty.MEDIUM
)
public class HouseRobberIV
{
	public int minCapability(int[] nums, int k)
	{
		int left = 1;
		int right = 1_000_000_000;
		int mid;
		int answer = 0;
		while (left <= right)
		{
			mid = (left + right) / 2;
			int use = 0;
			for (int i = 0; i < nums.length; i++)
			{
				if (nums[i] <= mid)
				{
					use++;
					i++;
				}
			}

			if (use >= k)
			{
				right = mid - 1;
				answer = mid;
			}
			else
			{
				left = mid + 1;
			}
		}

		return answer;
	}
}
