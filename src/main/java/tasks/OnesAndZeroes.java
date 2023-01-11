package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Aug-20
 */
@LeetCode(
		id = 474,
		name = "Ones and Zeroes",
		url = "https://leetcode.com/problems/ones-and-zeroes/",
		difficulty = Difficulty.MEDIUM
)
public class OnesAndZeroes
{
	public int findMaxForm(String[] strs, int zeroes, int ones)
	{
		int[][] ints = new int[strs.length][2];
		for (int i = 0; i < strs.length; i++)
		{
			for (char ch : strs[i].toCharArray())
			{
				ints[i][ch - '0']++;
			}
		}

		return findMax(0, ints, zeroes, ones, new Integer[strs.length][zeroes + 1][ones + 1]);
	}

	private int findMax(int pos, int[][] ints, int zeroes, int ones, Integer[][][] memo)
	{
		if (zeroes < 0 || ones < 0)
		{
			return Integer.MIN_VALUE;
		}

		if (pos == ints.length)
		{
			return 0;
		}

		if (memo[pos][zeroes][ones] != null)
		{
			return memo[pos][zeroes][ones];
		}

		int exclude = findMax(pos + 1, ints, zeroes, ones, memo);
		int include = findMax(pos + 1, ints, zeroes - ints[pos][0], ones - ints[pos][1], memo);
		include = include == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1 + include;

		memo[pos][zeroes][ones] = Math.max(exclude, include);
		return memo[pos][zeroes][ones];
	}
}
