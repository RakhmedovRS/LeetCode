package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/30/2021
 */
@LeetCode(
		id = 1995,
		name = "Count Special Quadruplets",
		url = "https://leetcode.com/problems/count-special-quadruplets/",
		difficulty = Difficulty.EASY
)
public class CountSpecialQuadruplets
{
	public int countQuadruplets(int[] nums)
	{
		int ans = 0;
		int n = nums.length;

		int[] sums = new int[201];

		for (int i = 2; i < n - 1; i++)
		{
			for (int j = 0; j < i - 1; j++)
			{
				int sum = nums[j] + nums[i - 1];
				sums[sum]++;
			}

			for (int j = i + 1; j < n; j++)
			{
				int delta = nums[j] - nums[i];
				ans += delta >= 0 ? sums[delta] : 0;
			}
		}
		return ans;
	}
}
