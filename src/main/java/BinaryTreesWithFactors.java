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
		TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
		for (int num : arr)
		{
			set.add(num);
		}

		Map<Integer, Integer> memo = new HashMap<>();
		int result = 0;
		for (int num : set)
		{
			result = (result + dfs(num, set, memo)) % MOD;
		}

		return result;
	}

	private int dfs(int num, Set<Integer> set, Map<Integer, Integer> memo)
	{
		long count = 1;

		if (memo.containsKey(num))
		{
			return memo.get(num);
		}

		long a;
		long b;
		for (int d : set)
		{
			if (num >= d && num % d == 0 && set.contains(num / d))
			{
				a = dfs(d, set, memo);
				b = dfs(num / d, set, memo);

				count = (count + (a * b) % MOD) % MOD;
			}
		}

		memo.put(num, (int) count);

		return (int) count;
	}
}
