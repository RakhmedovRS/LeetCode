package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2682,
		name = "Find the Losers of the Circular Game",
		url = "https://leetcode.com/problems/find-the-losers-of-the-circular-game/",
		difficulty = Difficulty.EASY
)
public class FindTheLosersOfTheCircularGame
{
	public int[] circularGameLosers(int n, int k)
	{
		int[] game = new int[n];
		int i = 0;
		int step = 1;
		while (true)
		{
			game[i]++;
			if (game[i] > 1)
			{
				break;
			}

			i += (step * k);
			step++;
			i %= n;
		}

		List<Integer> loosers = new ArrayList<>();
		for (int j = 0; j < n; j++)
		{
			if (game[j] == 0)
			{
				loosers.add(j);
			}
		}

		int[] ans = new int[loosers.size()];
		for (int j = 0; j < loosers.size(); j++)
		{
			ans[j] = loosers.get(j) + 1;
		}

		return ans;
	}
}
