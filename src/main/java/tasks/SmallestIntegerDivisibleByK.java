package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/29/2020
 */
@LeetCode(
	id = 1015,
	name = "Smallest Integer Divisible by K",
	url = "https://leetcode.com/problems/smallest-integer-divisible-by-k/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestIntegerDivisibleByK
{
	public int smallestRepunitDivByK(int K)
	{
		if (K % 2 == 0 || K % 5 == 0)
		{
			return -1;
		}

		int len = 1;
		int number = 1;
		while (number % K != 0)
		{
			number = (number * 10 + 1) % K;
			len++;
		}

		return len;
	}
}
