import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 13-Jul-20
 */
@LeetCode(id = 646, name = "Maximum Length of Pair Chain", url = "https://leetcode.com/problems/maximum-length-of-pair-chain/")
public class MaximumLengthOfPairChain
{
	public int findLongestChain(int[][] pairs)
	{
		int max = 1;
		Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));
		int[] memo = new int[pairs.length];
		Arrays.fill(memo, 1);
		for (int i = 1; i < pairs.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (pairs[j][1] < pairs[i][0])
				{
					memo[i] = Math.max(memo[j] + 1, memo[i]);
					max = Math.max(max, memo[i]);
				}
			}
		}

		return max;
	}
}
