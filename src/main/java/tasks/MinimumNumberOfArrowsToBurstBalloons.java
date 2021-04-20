package tasks;

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

		Arrays.sort(points, (p1, p2) ->
		{
			if (p1[1] == p2[1])
			{
				return Long.compare(p1[0], p2[0]);
			}

			return Long.compare(p1[1], p2[1]);
		});

		int count = 1;
		int prev = 0;
		for (int i = 1; i < points.length; i++)
		{
			if (points[i][0] <= points[prev][1])
			{
				continue;
			}
			else
			{
				count++;
				prev = i;
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{
			{Integer.MIN_VALUE,Integer.MIN_VALUE},
			{Integer.MAX_VALUE,Integer.MAX_VALUE},
		}));

		System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{
			{1,2},
			{2,3},
			{3,4},
			{4,5}
		}));

		System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{
			{1,2},
			{3,4},
			{5,6},
			{7,8}
		}));

		System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{
			{10,16},
			{2,8},
			{1,6},
			{7,12}
		}));
	}
}
