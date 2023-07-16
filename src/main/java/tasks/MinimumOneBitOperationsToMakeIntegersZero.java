package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/4/2020
 */
@LeetCode(id = 1611, name = "Minimum One Bit Operations to Make Integers Zero", url = "https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/")
public class MinimumOneBitOperationsToMakeIntegersZero
{
	public int minimumOneBitOperations(int n)
	{
		int steps = 0;
		for (int i = 0; i < 31; i++)
		{
			if ((n & (1 << i)) != 0)
			{
				steps = (int) Math.pow(2, i + 1) - 1 - steps;
			}
		}
		return steps;
	}
}
