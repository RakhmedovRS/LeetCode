package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 25-May-20
 */
@LeetCode(
	id = 1035,
	name = "Uncrossed Lines",
	url = "https://leetcode.com/problems/uncrossed-lines/",
	difficulty = Difficulty.MEDIUM
)
public class UncrossedLines
{
	public int maxUncrossedLines(int[] A, int[] B)
	{
		int[][] memo = new int[A.length][B.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		return maxUncrossedLines(A, B, 0, 0, memo);
	}

	private int maxUncrossedLines(int[] A, int[] B, int aIndex, int bIndex, int[][] memo)
	{
		if (aIndex >= A.length || bIndex >= B.length)
		{
			return 0;
		}

		if (memo[aIndex][bIndex] != -1)
		{
			return memo[aIndex][bIndex];
		}

		int max = 0;
		int aIdx = aIndex;
		int bIdx;
		for (; aIdx < A.length; aIdx++)
		{
			bIdx = bIndex;
			while (bIdx < B.length && B[bIdx] != A[aIdx])
			{
				bIdx++;
			}
			if (bIdx == B.length)
			{
				continue;
			}

			max = Math.max(max, 1 + maxUncrossedLines(A, B, aIdx + 1, bIdx + 1, memo));
		}

		memo[aIndex][bIndex] = max;
		return max;
	}
}
