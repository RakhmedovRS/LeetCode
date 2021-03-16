import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 31-Aug-20
 */
@LeetCode(
	id = 823,
	name = "Binary Trees With Factors",
	url = "https://leetcode.com/problems/binary-trees-with-factors/",
	difficulty = Difficulty.MEDIUM
)
public class BinaryTreesWithFactors
{
	private static final int MOD = 1_000_000_007;

	public int numFactoredBinaryTrees(int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		for (int num : arr)
		{
			set.add(num);
		}

		Map<Integer, Integer> memo = new HashMap<>();
		int result = 0;

		arr = new int[set.size()];
		int i = 0;
		for (int num : set)
		{
			arr[i++] = num;
		}

		Arrays.sort(arr);

		for (int j = arr.length - 1; j >= 0; j--)
		{
			result = (result + dfs(arr[j], set, arr, memo)) % MOD;
		}

		return result;
	}

	private int dfs(int num, Set<Integer> set, int[] arr, Map<Integer, Integer> memo)
	{
		long count = 1;

		if (memo.containsKey(num))
		{
			return memo.get(num);
		}

		long a;
		long b;
		int d;
		for (int i = arr.length - 1; i >= 0; i--)
		{
			d = arr[i];
			if (num >= d && num % d == 0 && set.contains(num / d))
			{
				a = dfs(d, set, arr, memo);
				b = dfs(num / d, set, arr, memo);

				count = (count + (a * b) % MOD) % MOD;
			}
		}

		memo.put(num, (int) count);

		return (int) count;
	}
}
