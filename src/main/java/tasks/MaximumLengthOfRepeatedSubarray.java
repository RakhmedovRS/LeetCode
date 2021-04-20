package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/20/2020
 */
@LeetCode(
	id = 718,
	name = "Maximum Length of Repeated Subarray",
	url = "https://leetcode.com/problems/maximum-length-of-repeated-subarray/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumLengthOfRepeatedSubarray
{
	public int findLength(int[] A, int[] B)
	{
		return dfs(0, 0, A, B, new Integer[A.length][B.length]);
	}

	private int dfs(int aPos, int bPos, int[] A, int[] B, Integer[][] memo)
	{
		if (aPos >= A.length || bPos >= B.length)
		{
			return 0;
		}

		if (memo[aPos][bPos] != null)
		{
			return memo[aPos][bPos];
		}

		int current = 0;
		if (A[aPos] == B[bPos])
		{
			int a = aPos;
			int b = bPos;
			while (a < A.length && b < B.length && A[a] == B[b])
			{
				current++;
				a++;
				b++;
			}
		}

		memo[aPos][bPos] = Math.max(current, Math.max(dfs(aPos + 1, bPos, A, B, memo), dfs(aPos, bPos + 1, A, B, memo)));
		return memo[aPos][bPos];
	}
}
