import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Aug-20
 */
@LeetCode(id = 1031, name = "Maximum Sum of Two Non-Overlapping Subarrays", url = "https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/")
public class MaximumSumOfTwoNonOverlappingSubarrays
{
	public int maxSumTwoNoOverlap(int[] A, int L, int M)
	{
		if (A.length < L + M)
		{
			return 0;
		}

		int[] prefix = new int[A.length + 1];
		for (int i = 1; i < prefix.length; i++)
		{
			prefix[i] = prefix[i - 1] + A[i - 1];
		}
		return Math.max(dfs(prefix, L, M), dfs(prefix, M, L));
	}

	public int dfs(int[] prefix, int L, int M)
	{
		int max = 0;
		for (int lL = 1, lR = L; lR <= prefix.length - M; lL++, lR++)
		{
			int leftSum = prefix[lR] - prefix[lL - 1];
			for (int rL = lR + 1, rR = rL + M - 1; rR < prefix.length; rL++, rR++)
			{
				int rightSum = prefix[rR] - prefix[rL - 1];
				max = Math.max(max, leftSum + rightSum);
			}
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
		System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 2, 1));
		System.out.println(new MaximumSumOfTwoNonOverlappingSubarrays().maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
	}
}
