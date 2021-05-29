package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/29/2021
 */
@LeetCode(
	id = 1879,
	name = "Minimum XOR Sum of Two Arrays",
	url = "https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/",
	difficulty = Difficulty.HARD
)
public class MinimumXORSumOfTwoArrays
{
	public int minimumXORSum(int[] nums1, int[] nums2)
	{
		Integer[] memo = new Integer[1 << nums1.length];
		return dfs(0, 0, nums1, nums2, memo);
	}

	private int dfs(int pos, int mask, int[] nums1, int[] nums2, Integer[] memo)
	{
		if (pos >= nums1.length)
		{
			return 0;
		}

		if (memo[mask] != null)
		{
			return memo[mask];
		}

		memo[mask] = Integer.MAX_VALUE;
		for (int i = 0; i < nums2.length; i++)
		{
			if ((mask & (1 << i)) == 0)
			{
				memo[mask] = Math.min(memo[mask], (nums1[pos] ^ nums2[i]) + dfs(pos + 1, mask + (1 << i), nums1, nums2, memo));
			}
		}

		return memo[mask];
	}
}
