package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/24/2021
 */
@LeetCode(
	id = 1137,
	name = "N-th Tribonacci Number",
	url = "https://leetcode.com/problems/n-th-tribonacci-number/",
	difficulty = Difficulty.EASY
)
public class NthTribonacciNumber
{
	public int tribonacci(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n <= 2)
		{
			return 1;
		}

		int[] memo = new int[n + 1];
		memo[1] = memo[2] = 1;
		for (int i = 3; i < memo.length; i++)
		{
			memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1];
		}

		return memo[n];
	}
}
