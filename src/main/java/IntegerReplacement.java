import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(id = 397, name = "Integer Replacement", url = "https://leetcode.com/problems/integer-replacement/")
public class IntegerReplacement
{
	public int integerReplacement(int n)
	{
		return dfs(n, new HashMap<>());
	}

	private int dfs(long n, Map<Long, Integer> memo)
	{
		if (n <= 1)
		{
			return 0;
		}

		if (memo.containsKey(n))
		{
			return memo.get(n);
		}

		int res;
		if (n % 2 == 0)
		{
			res = 1 + dfs(n / 2, memo);
		}
		else
		{
			res = 1 + Math.min(dfs(n - 1, memo), dfs(n + 1, memo));
		}

		memo.put(n, res);

		return res;
	}
}
