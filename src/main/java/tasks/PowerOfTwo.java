package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@LeetCode(
	id = 231,
	name = "Power of Two",
	url = "https://leetcode.com/problems/power-of-two/",
	difficulty = Difficulty.EASY
)
public class PowerOfTwo
{
	public boolean isPowerOfTwo(int n)
	{
		int left = 0;
		int right = n;
		int middle;
		long res;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			res = (long) Math.pow(2, middle);
			if (res == n)
			{
				return true;
			}
			else if (res > n)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		return false;
	}
}
