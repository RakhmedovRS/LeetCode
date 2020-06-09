import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 354, name = "Russian Doll Envelopes", url = "https://leetcode.com/problems/russian-doll-envelopes/")
public class RussianDollEnvelopes
{
	public int maxEnvelopes(int[][] envelopes)
	{
		if (envelopes == null || envelopes.length == 0)
		{
			return 0;
		}

		int max = 1;
		Arrays.sort(envelopes, (e1, e2) ->
		{
			if (e1[0] == e2[0])
			{
				return e1[1] - e2[1];
			}
			else
			{
				return e1[0] - e2[0];
			}
		});

		int[] memo = new int[envelopes.length];
		Arrays.fill(memo, 1);
		for (int i = 1; i < memo.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
				{
					memo[i] = Math.max(memo[i], memo[j] + 1);
					max = Math.max(max, memo[i]);
				}
			}
		}

		return max;
	}
}
