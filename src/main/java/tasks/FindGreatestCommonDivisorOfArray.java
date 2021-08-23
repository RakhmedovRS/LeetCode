package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/22/2021
 */
@LeetCode(
	id = 1979,
	name = "Find Greatest Common Divisor of Array",
	url = "https://leetcode.com/problems/find-greatest-common-divisor-of-array/",
	difficulty = Difficulty.EASY
)
public class FindGreatestCommonDivisorOfArray
{
	public int findGCD(int[] nums)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums)
		{
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		return gcd(min, max);
	}

	private int gcd(int x, int y)
	{
		if (y == 0)
		{
			return x;
		}
		return gcd(y, x % y);
	}
}
