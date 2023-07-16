package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 3/6/2023
 */
@LeetCode(
		id = 2580,
		name = "Count Ways to Group Overlapping Ranges",
		url = "https://leetcode.com/problems/count-ways-to-group-overlapping-ranges/",
		difficulty = Difficulty.MEDIUM
)
public class CountWaysToGroupOverlappingRanges
{
	int MOD = 1_000_000_007;

	public int countWays(int[][] ranges)
	{
		Arrays.sort(ranges, (a, b) -> {
			if (a[0] == b[0])
			{
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		LinkedList<int[]> list = new LinkedList<>();
		for (int[] range : ranges)
		{
			if (list.isEmpty())
			{
				list.addLast(range);
			}
			else
			{
				if (list.getLast()[1] >= range[0])
				{
					int[] prev = list.removeLast();
					prev[0] = Math.min(prev[0], range[0]);
					prev[1] = Math.max(prev[1], range[1]);
					list.addLast(prev);
				}
				else
				{
					list.addLast(range);
				}
			}
		}


		return (int) (powerMod(2, list.size(), MOD) % MOD);
	}

	public long powerMod(long base, long exp, long mod)
	{
		long result = 1;
		base %= mod;
		while (exp > 0)
		{
			if ((exp & 1) != 0)
			{
				result = (result * base) % mod;
			}
			exp >>= 1;
			base = base * base % mod;
		}
		return result < 0 ? result + mod : result;
	}
}
