import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(id = 1010, name = "Pairs of Songs With Total Durations Divisible by 60", url = "https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/")
public class PairsOfSongsWithTotalDurationsDivisibleBy60
{
	public int numPairsDivisibleBy60(int[] time)
	{
		int[] lengths = new int[60];
		for (int t : time)
		{
			lengths[t % 60]++;
		}
		int pairs = 0;
		for (int i = 0; i <= 30; i++)
		{
			if (i == 0 || i == 30)
			{
				pairs += lengths[i] * (lengths[i] - 1) / 2;
			}
			else
			{
				pairs += lengths[i] * lengths[60 - i];
			}

		}

		return pairs;
	}
}
