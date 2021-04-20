package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/18/2021
 */
@LeetCode(
	id = 1835,
	name = "Find XOR Sum of All Pairs Bitwise AND",
	url = "https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/",
	difficulty = Difficulty.HARD
)
public class FindXORSumOfAllPairsBitwiseAND
{
	public int getXORSum(int[] A, int[] B)
	{
		int xorA = 0;
		int xorB = 0;
		for (int a : A)
		{
			xorA ^= a;
		}

		for (int b : B)
		{
			xorB ^= b;
		}
		return xorA & xorB;
	}
}
