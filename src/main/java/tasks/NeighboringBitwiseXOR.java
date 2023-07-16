package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2683,
		name = "Neighboring Bitwise XOR",
		url = "https://leetcode.com/problems/neighboring-bitwise-xor/",
		difficulty = Difficulty.MEDIUM
)
public class NeighboringBitwiseXOR
{
	public boolean doesValidArrayExist(int[] derived)
	{
		if (derived.length == 1)
		{
			return derived[0] == 0;
		}

		int[] A = new int[derived.length];
		int[] B = new int[derived.length];
		B[0] = 1;

		boolean validA = true;
		boolean validB = true;
		for (int i = 1; i < derived.length && (validA || validB); i++)
		{
			if (validA)
			{
				if ((A[i - 1] ^ 1) == derived[i - 1])
				{
					A[i] = 1;
				}
				else if ((A[i - 1] ^ 0) == derived[i - 1])
				{
					A[i] = 0;
				}
				else
				{
					validA = false;
				}
			}

			if (validB)
			{
				if ((B[i - 1] ^ 1) == derived[i - 1])
				{
					B[i] = 1;
				}
				else if ((B[i - 1] ^ 0) == derived[i - 1])
				{
					B[i] = 0;
				}
				else
				{
					validB = false;
				}
			}
		}

		if (validA)
		{
			if ((A[derived.length - 1] ^ A[0]) == derived[derived.length - 1])
			{
			}
			else
			{
				validA = false;
			}
		}

		if (validB)
		{
			if ((B[derived.length - 1] ^ B[0]) == derived[derived.length - 1])
			{
			}
			else
			{
				validB = false;
			}
		}

		if (validA)
		{
			if ((A[0] ^ A[1]) == derived[0])
			{
			}
			else
			{
				validA = false;
			}
		}

		if (validB)
		{
			if ((B[0] ^ B[1]) == derived[0])
			{
			}
			else
			{
				validB = false;
			}
		}


		return validA || validB;
	}
}
