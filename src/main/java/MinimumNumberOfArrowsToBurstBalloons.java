import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 29-Jul-20
 */
@LeetCode(id = 452, name = "Minimum Number of Arrows to Burst Balloons", url = "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/")
public class MinimumNumberOfArrowsToBurstBalloons
{
	public int findMinArrowShots(int[][] points)
	{
		if (points == null || points.length == 0)
		{
			return 0;
		}

		Arrays.sort(points, (a1, a2) ->
		{
			if (a1[0] == a2[0])
			{
				return a1[1] - a2[1];
			}
			return a1[0] - a2[0];
		});

		int pos = 0;
		int maxEnd = points[pos][1];
		int arrows = 1;
		while (pos < points.length)
		{
			while (pos < points.length && points[pos][0] <= maxEnd)
			{
				maxEnd = Math.min(maxEnd, points[pos][1]);
				pos++;
			}

			if (pos < points.length)
			{
				maxEnd = points[pos][1];
				arrows++;
			}
		}

		return arrows;
	}
}
