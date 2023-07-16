package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
		id = 473,
		name = "Matchsticks to Square",
		url = "https://leetcode.com/problems/matchsticks-to-square/",
		difficulty = Difficulty.MEDIUM
)
public class MatchsticksToSquare
{
	public boolean makesquare(int[] matchsticks)
	{
		boolean[] used = new boolean[matchsticks.length];

		int sum = 0;
		Arrays.sort(matchsticks);
		for (int matchstick : matchsticks)
		{
			sum += matchstick;
		}

		if (sum % 4 != 0 || matchsticks.length < 4)
		{
			return false;
		}

		return dfs(sum / 4, matchsticks, used)
				&& dfs(sum / 4, matchsticks, used)
				&& dfs(sum / 4, matchsticks, used)
				&& dfs(sum / 4, matchsticks, used);
	}

	private boolean dfs(int sum, int[] matchsticks, boolean[] used)
	{
		if (sum == 0)
		{
			return true;
		}

		for (int i = matchsticks.length - 1; i >= 0; i--)
		{
			if (!used[i] && sum - matchsticks[i] >= 0)
			{
				used[i] = true;
				if (dfs(sum - matchsticks[i], matchsticks, used))
				{
					return true;
				}
				used[i] = false;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		MatchsticksToSquare clazz = new MatchsticksToSquare();
		System.out.println(clazz.makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
	}
}
