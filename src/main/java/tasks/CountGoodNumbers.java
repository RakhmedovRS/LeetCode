package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/4/2021
 */
@LeetCode(
	id = 1922,
	name = "Count Good Numbers",
	url = "https://leetcode.com/problems/count-good-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class CountGoodNumbers
{
	public int countGoodNumbers(long n)
	{
		int mod = 1_000_000_007;
		java.math.BigInteger even = java.math.BigInteger.valueOf(5).modPow(java.math.BigInteger.valueOf((n + 1) / 2), java.math.BigInteger.valueOf(mod));
		java.math.BigInteger odd = java.math.BigInteger.valueOf(4).modPow(java.math.BigInteger.valueOf(n / 2), java.math.BigInteger.valueOf(mod));
		java.math.BigInteger res = even.multiply(odd).mod(java.math.BigInteger.valueOf(mod));

		return res.intValue();
	}
}
