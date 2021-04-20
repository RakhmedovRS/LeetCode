package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(id = 1007, name = "Minimum Domino Rotations For Equal Row", url = "https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/")
public class MinimumDominoRotationsForEqualRow
{
	public int minDominoRotations(int[] A, int[] B)
	{
		int a = countOfSwaps(A[0], A, B);
		int b = countOfSwaps(A[0], B, A);
		int c = countOfSwaps(B[0], A, B);
		int d = countOfSwaps(B[0], B, A);
		int min = Math.min(a, Math.min(b, Math.min(c, d)));

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private int countOfSwaps(int val, int[] A, int[] B)
	{
		int count = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] == val)
			{
				continue;
			}
			else if (B[i] == val)
			{
				count++;
			}
			else
			{
				return Integer.MAX_VALUE;
			}
		}

		return count;
	}
}
