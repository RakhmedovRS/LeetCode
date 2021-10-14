package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
@LeetCode(
	id = 279,
	name = "Perfect Squares",
	url = "https://leetcode.com/problems/perfect-squares/",
	difficulty = Difficulty.MEDIUM
)
public class PerfectSquares
{
	public int numSquares(int n)
	{
		int[] memo = new int[n + 1];
		memo[0] = 0;
		int max = Math.abs(Integer.MIN_VALUE / 2);
		for (int i = 1; i < memo.length; i++)
		{
			memo[i] = Integer.MAX_VALUE;
			for (int a = 1; a < max && i - a * a >= 0; a++)
			{
				memo[i] = Math.min(memo[i], 1 + memo[i - a * a]);
			}
		}

		return memo[n];
	}

	public static void main(String[] args)
	{
		System.out.println(new PerfectSquares().numSquares(13));
	}
}
