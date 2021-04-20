package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/10/2021
 */
@LeetCode(
	id = 1823,
	name = "Find the Winner of the Circular Game",
	url = "https://leetcode.com/problems/find-the-winner-of-the-circular-game/",
	difficulty = Difficulty.MEDIUM
)
public class FindTheWinnerOfTheCircularGame
{
	public int findTheWinner(int n, int k)
	{
		boolean[] friends = new boolean[n];
		int seen = 0;
		int count = n;
		for (int i = 0; count > 1; i = (i + 1) % n)
		{
			if (!friends[i])
			{
				seen++;
			}
			else
			{
				continue;
			}

			if (seen % k == 0)
			{
				count--;
				friends[i] = true;
			}
		}

		for (int i = 0; i < friends.length; i++)
		{
			if (!friends[i])
			{
				return i + 1;
			}
		}

		return 1;
	}
}
