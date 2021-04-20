package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12-Aug-20
 */
@LeetCode(id = 1416, name = "Restore The Array", url = "https://leetcode.com/problems/restore-the-array/")
public class RestoreTheArray
{
	public int numberOfArrays(String s, int k)
	{
		long[] memo = new long[s.length()];
		Arrays.fill(memo, -1);
		return (int) (dfs(s.toCharArray(), 0, k, memo) % (int) (1e9 + 7));
	}

	private long dfs(char[] chars, int pos, int k, long[] memo)
	{
		if (pos == chars.length)
		{
			return 1L;
		}

		if (chars[pos] == '0')
		{
			return 0L;
		}

		if (memo[pos] != -1)
		{
			return memo[pos];
		}

		long res = 0;
		long num;
		for (int i = pos; i < chars.length; i++)
		{
			num = createNumber(chars, pos, i);
			if (num > k)
			{
				break;
			}

			res += dfs(chars, i + 1, k, memo) % (int) (1e9 + 7);
		}

		memo[pos] = res % (int) (1e9 + 7);
		return memo[pos];
	}

	private long createNumber(char[] chars, int start, int end)
	{
		long number = 0;
		for (int i = start; i <= end; i++)
		{
			number *= 10;
			number += chars[i] - '0';
		}
		return number;
	}
}
