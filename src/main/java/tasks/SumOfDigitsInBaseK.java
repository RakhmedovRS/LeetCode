package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/25/2021
 */
@LeetCode(
		id = 1837,
		name = "Sum of Digits in Base K",
		url = "https://leetcode.com/problems/sum-of-digits-in-base-k/",
		difficulty = Difficulty.EASY
)
public class SumOfDigitsInBaseK
{
	public int sumBase(int n, int k)
	{
		int sum = 0;
		while (n >= k)
		{
			sum += n % k;
			n /= k;
		}

		return sum + n;
	}
}
