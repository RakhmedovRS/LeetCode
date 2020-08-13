import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 13-Aug-20
 */
@LeetCode(id = 1288, name = "Remove Covered Intervals", url = "https://leetcode.com/problems/remove-covered-intervals/")
public class RemoveCoveredIntervals
{
	public int removeCoveredIntervals(int[][] intervals)
	{
		if (intervals == null || intervals.length == 0)
		{
			return 0;
		}

		Arrays.sort(intervals, (arr1, arr2) ->
		{
			if (arr1[0] == arr2[0])
			{
				return arr2[1] - arr1[1];
			}
			return arr1[0] - arr2[0];
		});

		int[] previous = intervals[0];
		int uncovered = 1;
		for (int i = 1; i < intervals.length; i++)
		{
			int[] current = intervals[i];
			if (previous[1] < current[1])
			{
				previous = current;
				uncovered++;
			}
		}

		return uncovered;
	}
}
