package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2021
 */
@LeetCode(
	id = 2110,
	name = "Number of Smooth Descent Periods of a Stock",
	url = "https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/",
	difficulty = Difficulty.MEDIUM
)
public class NumberOfSmoothDescentPeriodsOfStock
{
	public long getDescentPeriods(int[] prices)
	{
		if (prices.length == 1)
		{
			return 1;
		}

		long answer = 0;
		int pos = 1;
		long current = 1;
		while (pos < prices.length)
		{
			if (prices[pos - 1] - prices[pos] == 1)
			{
				current++;
			}
			else
			{
				answer += (current * (current + 1)) / 2;
				current = 1;
			}

			pos++;
		}

		answer += (current * (current + 1)) / 2;

		return answer;
	}
}
