package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(
		id = 91,
		name = "Decode Ways",
		url = "https://leetcode.com/problems/decode-ways/",
		difficulty = Difficulty.MEDIUM
)
public class DecodeWays
{
	public int numDecodings(String s)
	{
		int[] memo = new int[s.length()];
		return dfs(0, s.toCharArray(), memo);
	}

	private int dfs(int pos, char[] chars, int[] memo)
	{
		if (pos >= chars.length)
		{
			return 1;
		}

		if (memo[pos] != 0)
		{
			return memo[pos];
		}

		if (chars[pos] == '0')
		{
			return 0;
		}

		memo[pos] += dfs(pos + 1, chars, memo);
		if (pos + 1 < chars.length)
		{
			int num = (chars[pos] - '0') * 10 + (chars[pos + 1] - '0');
			if (num <= 26)
			{
				memo[pos] += dfs(pos + 2, chars, memo);
			}
		}

		return memo[pos];
	}
}
