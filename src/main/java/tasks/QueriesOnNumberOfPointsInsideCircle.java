package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 4/17/2021
 */
@LeetCode(
		id = 1828,
		name = "Queries on Number of Points Inside a Circle",
		url = "https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/",
		difficulty = Difficulty.MEDIUM
)
public class QueriesOnNumberOfPointsInsideCircle
{
	public int[] countPoints(int[][] points, int[][] queries)
	{
		int[][] memo = new int[501][501];
		for (int[] point : points)
		{
			memo[point[0]][point[1]]++;
		}

		List<int[]> pointsInfo = new ArrayList<>();
		for (int row = 0; row < 501; row++)
		{
			for (int column = 0; column < 501; column++)
			{
				if (memo[row][column] > 0)
				{
					pointsInfo.add(new int[]{row, column, memo[row][column]});
				}
			}
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			for (int[] point : pointsInfo)
			{
				if (isPointWithin(queries[i][0], point[0], queries[i][1], point[1], queries[i][2]))
				{
					answer[i] += point[2];
				}
			}
		}
		return answer;
	}

	private boolean isPointWithin(int x1, int x2, int y1, int y2, int radius)
	{
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= radius;
	}
}
