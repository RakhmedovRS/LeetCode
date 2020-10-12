import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/12/2020
 */
@LeetCode(id = 801, name = "Minimum Swaps To Make Sequences Increasing", url = "https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/")
public class MinimumSwapsToMakeSequencesIncreasing
{
	public int minSwap(int[] A, int[] B)
	{
		Integer[][] memo = new Integer[A.length][2];
		return dfs(A, B, 0, -1, -1, memo, 0);
	}

	private int dfs(int[] A, int[] B, int pos, int prevA, int prevB, Integer[][] memo, int swapped)
	{
		if (pos == A.length)
		{
			return 0;
		}

		if (memo[pos][swapped] != null)
		{
			return memo[pos][swapped];
		}

		int withSwap = Integer.MAX_VALUE;
		int withoutSwap = Integer.MAX_VALUE;

		if (prevA < A[pos] && prevB < B[pos])
		{
			withoutSwap = dfs(A, B, pos + 1, A[pos], B[pos], memo, 0);
			if (prevA < B[pos] && prevB < A[pos] && A[pos] != B[pos])
			{
				withSwap = 1 + dfs(A, B, pos + 1, B[pos], A[pos], memo, 1);
			}
		}
		else
		{
			withSwap = 1 + dfs(A, B, pos + 1, B[pos], A[pos], memo, 1);
		}

		return memo[pos][swapped] = Math.min(withSwap, withoutSwap);
	}
}
