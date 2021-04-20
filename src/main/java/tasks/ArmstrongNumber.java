package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 1134,
	name = "Armstrong Number",
	url = "https://leetcode.com/problems/armstrong-number/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class ArmstrongNumber
{
	public boolean isArmstrong(int N)
	{
		int num = N;
		long sum = 0;
		int pow = String.valueOf(N).length();
		while (num > 0)
		{
			sum += Math.pow(num % 10, pow);
			if (sum > Integer.MAX_VALUE)
			{
				return false;
			}
			num /= 10;
		}

		return sum == N;
	}
}
