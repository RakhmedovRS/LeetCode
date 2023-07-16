package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 6/25/2023
 */
@LeetCode(
		id = 2748,
		name = "Number of Beautiful Pairs",
		url = "https://leetcode.com/problems/number-of-beautiful-pairs/description/",
		difficulty = Difficulty.EASY
)
public class NumberOfBeautifulPairs
{
	public int countBeautifulPairs(int[] nums)
	{
		int c = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int d1 = String.valueOf(nums[i]).charAt(0) - '0';
			for (int j = i + 1; j < nums.length; j++)
			{
				int d2 = nums[j] % 10;
				if (gcd(d1, d2) == 1)
				{
					c++;
				}
			}
		}

		return c;
	}

	public int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}
}
