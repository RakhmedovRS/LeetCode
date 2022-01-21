package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Mar-20
 */
@LeetCode(
	id = 134,
	name = "Gas Station",
	url = "https://leetcode.com/problems/gas-station/",
	difficulty = Difficulty.MEDIUM
)
public class GasStation
{
	public int canCompleteCircuit(int[] gas, int[] cost)
	{
		int tank = 0;
		for (int i = 0; i < gas.length; i++)
		{
			tank += gas[i] - cost[i];
		}
		if (tank < 0)
		{
			return -1;
		}

		int start = 0;
		int accumulate = 0;
		for (int i = 0; i < gas.length; i++)
		{
			int curGain = gas[i] - cost[i];
			if (accumulate + curGain < 0)
			{
				start = i + 1;
				accumulate = 0;
			}
			else
			{
				accumulate += curGain;
			}
		}

		return start;
	}
}
