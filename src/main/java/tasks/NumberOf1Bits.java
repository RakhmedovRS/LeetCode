package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(
		id = 191,
		name = "Number of 1 Bits",
		url = "https://leetcode.com/problems/number-of-1-bits/",
		difficulty = Difficulty.EASY
)
public class NumberOf1Bits
{
	public int hammingWeight(int n)
	{
		int bits = 0;
		for (int i = 0; i < 32; i++)
		{
			bits += (n & 1);
			n >>= 1;
		}

		return bits;
	}
}
