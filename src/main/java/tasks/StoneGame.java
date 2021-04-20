package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 23-Jul-20
 */
@LeetCode(id = 877, name = "Stone Game", url = "https://leetcode.com/problems/stone-game/")
public class StoneGame
{
	public boolean stoneGame(int[] piles)
	{
		int[][] memo = new int[piles.length][piles.length];
		int[] sums = new int[piles.length];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		int sum = 0;
		for (int i = 0; i < piles.length; i++)
		{
			sum += piles[i];
			sums[i] = sum;
		}

		int alex = helper(piles, 0, piles.length - 1, sums, memo);
		return alex > sums[piles.length - 1] - alex;
	}

	private int helper(int[] piles, int left, int right, int[] sums, int memo[][])
	{
		if (left > right)
		{
			return 0;
		}

		if (memo[left][right] != -1)
		{
			return memo[left][right];
		}

		int sum = sums[right] - sums[left] + piles[left];
		memo[left][right] = sum - Math.min(helper(piles, left + 1, right, sums, memo), helper(piles, left, right - 1, sums, memo));
		return memo[left][right];
	}
}
