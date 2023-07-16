package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/20/2022
 */
@LeetCode(
		id = 2470,
		name = "Number of Subarrays With LCM Equal to K",
		difficulty = Difficulty.MEDIUM,
		url = "https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/"
)
public class NumberOfSubarraysWithLCMEqualToK
{
	public int subarrayLCM(int[] nums, int k)
	{
		int result = 0;
		outer:
		for (int i = 0; i < nums.length; i++)
		{
			int lcm = nums[i];
			if (lcm == k)
			{
				result++;
			}

			for (int j = i + 1; j < nums.length; j++)
			{
				lcm = lcm(lcm, nums[j]);
				if (lcm == k)
				{
					result++;
				}
			}
		}

		return result;
	}

	private int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}

	private int lcm(int a, int b)
	{
		return (a / gcd(a, b)) * b;
	}
}
