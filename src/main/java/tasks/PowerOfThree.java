package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(
	id = 326,
	name = "Power of Three",
	url = "https://leetcode.com/problems/power-of-three/",
	difficulty = Difficulty.EASY
)
public class PowerOfThree
{
	public boolean isPowerOfThree(int n)
	{
		if (n == 0 || n == 2)
		{
			return false;
		}

		if (n == 1 || n == 3)
		{
			return true;
		}

		return n % 3 == 0 && isPowerOfThree(n / 3);
	}
}
