package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-Aug-20
 */
@LeetCode(id = 1288, name = "Remove Covered Intervals", url = "https://leetcode.com/problems/remove-covered-intervals/")
public class RemoveCoveredIntervals
{
	public int removeCoveredIntervals(int[][] intervals)
	{
		Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i2[1] - i1[1] : i1[0] - i2[0]);
		List<int[]> intervalsList = new ArrayList<>();
		int[] prev;
		for (int[] interval : intervals)
		{
			if (intervalsList.isEmpty())
			{
				intervalsList.add(interval);
				continue;
			}

			prev = intervalsList.get(intervalsList.size() - 1);
			if (prev[0] <= interval[0] && interval[1] <= prev[1])
			{
				prev[0] = Math.min(prev[0], interval[0]);
				prev[1] = Math.max(prev[1], interval[1]);
			}
			else
			{
				intervalsList.add(interval);
			}
		}

		return intervalsList.size();
	}
}
