package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/30/2023
 */
@LeetCode(
		id = 2550,
		name = "Count Collisions of Monkeys on a Polygon",
		url = "https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/",
		difficulty = Difficulty.MEDIUM
)
public class CountCollisionsOfMonkeysOnPolygon
{
	int MOD = 1_000_000_007;

	public int monkeyMove(int n)
	{
		long a = (int) powerMod(2, n - 3, MOD);

		return (int) (((6 * a) % MOD + (2 * (a - 1) % MOD)) % MOD);
	}

	public static long powerMod(long base, long exp, long mod)
	{
		long result = 1;
		base %= mod;
		while (exp > 0)
		{
			if ((exp & 1) != 0)
			{
				result = (result * base) % mod;
			}
			exp >>= 1;
			base = base * base % mod;
		}
		return result < 0 ? result + mod : result;
	}
}
