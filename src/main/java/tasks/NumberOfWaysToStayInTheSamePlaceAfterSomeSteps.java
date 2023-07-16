package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Sep-20
 */
@LeetCode(id = 1269, name = "Number of Ways to Stay in the Same Place After Some Steps", url = "https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/")
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps
{
	int MOD = (int) (Math.pow(10, 9) + 7);

	public int numWays(int steps, int arrLen)
	{
		Integer[][] memo = new Integer[steps + 1][Math.min(steps / 2, arrLen - 1) + 1];
		return dfs(0, steps, memo) % MOD;
	}

	private int dfs(int pos, int steps, Integer[][] memo)
	{
		if (steps == 0)
		{
			return pos == 0 ? 1 : 0;
		}

		if (memo[steps][pos] != null)
		{
			return memo[steps][pos];
		}

		long goLeft = pos > 0 ? dfs(pos - 1, steps - 1, memo) % MOD : 0;
		long stay = dfs(pos, steps - 1, memo) % MOD;
		long goRight = pos + 1 < memo[0].length ? dfs(pos + 1, steps - 1, memo) % MOD : 0;

		memo[steps][pos] = (int) ((stay + goLeft + goRight) % MOD);
		return memo[steps][pos];
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().numWays(3, 2));
		System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().numWays(430, 148488));
		System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps().numWays(27, 7));
	}
}
