import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 31-Aug-20
 */
@LeetCode(id = 823, name = "Binary Trees With Factors", url = "https://leetcode.com/problems/binary-trees-with-factors/")
public class BinaryTreesWithFactors
{
	public int numFactoredBinaryTrees(int[] A)
	{
		Arrays.sort(A);
		Map<Integer, Integer> numbers = new HashMap<>();
		Map<Integer, Long> memo = new HashMap<>();
		for (int i = 0; i < A.length; i++)
		{
			numbers.put(A[i], i);
		}

		for (int i = 0; i < A.length; i++)
		{
			dfs(A, i, memo, numbers);
		}

		long result = 0;
		for (Long count : memo.values())
		{
			result = (result + count) % (long)(1e9 + 7);
		}

		return (int) result;
	}

	private long dfs(int[] A, int pos, Map<Integer, Long> memo, Map<Integer, Integer> numbers)
	{
		if (memo.containsKey(A[pos]))
		{
			return memo.get(A[pos]);
		}

		long count = 1;
		for (int i = pos; i >= 0; i--)
		{
			if (A[pos] % A[i] == 0 && numbers.containsKey(A[pos] / A[i]))
			{
				count += dfs(A, i, memo, numbers) * dfs(A, numbers.get(A[pos] / A[i]), memo, numbers);
			}
		}

		memo.put(A[pos], count);
		return count;
	}
}
