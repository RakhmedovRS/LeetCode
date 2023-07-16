package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/13/2020
 */
@LeetCode(
		id = 1688,
		name = "Count of Matches in Tournament",
		url = "https://leetcode.com/problems/count-of-matches-in-tournament/",
		difficulty = Difficulty.EASY
)
public class CountOfMatchesInTournament
{
	public int numberOfMatches(int n)
	{
		int sum = 0;
		while (n != 1)
		{
			if (n % 2 == 0)
			{
				sum += n / 2;
				n /= 2;
			}
			else
			{
				sum += n / 2;
				n /= 2;
				n++;
			}
		}

		return sum;
	}
}
