package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(
		id = 1010,
		name = "Pairs of Songs With Total Durations Divisible by 60",
		url = "https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/",
		difficulty = Difficulty.MEDIUM
)
public class PairsOfSongsWithTotalDurationsDivisibleBy60
{
	public int numPairsDivisibleBy60(int[] time)
	{
		int[] memo = new int[61];
		int pos;
		int pairs = 0;
		for (int t : time)
		{
			pos = t % 60;
			pairs += memo[pos == 0 ? 0 : 60 - pos];
			memo[pos]++;
		}

		return pairs;
	}
}
