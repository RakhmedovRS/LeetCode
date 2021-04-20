package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(
	id = 354,
	name = "Russian Doll Envelopes",
	url = "https://leetcode.com/problems/russian-doll-envelopes/",
	difficulty = Difficulty.MEDIUM
)
public class RussianDollEnvelopes
{
	public int maxEnvelopes(int[][] envelopes)
	{
		int max = 1;
		Arrays.sort(envelopes, (a, b) ->
		{
			if (a[0] == b[0])
			{
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		int[] memo = new int[envelopes.length];
		Arrays.fill(memo, 1);
		for (int i = 1; i < envelopes.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
				{
					memo[i] = Math.max(memo[j] + 1, memo[i]);
				}
			}
			max = Math.max(max, memo[i]);
		}

		return max;
	}
}
