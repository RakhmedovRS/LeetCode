package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/6/2021
 */
@LeetCode(
	id = 1779,
	name = "Find Nearest Point That Has the Same X or Y Coordinate",
	url = "https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/",
	difficulty = Difficulty.EASY
)
public class FindNearestPointThatHasTheSameXorYCoordinate
{
	public int nearestValidPoint(int x, int y, int[][] points)
	{
		int minDistance = Integer.MAX_VALUE;
		int minIndex = -1;
		int distance;
		for (int i = 0; i < points.length; i++)
		{
			if (points[i][0] == x || points[i][1] == y)
			{
				distance = getManhattanDistance(x, y, points[i][0], points[i][1]);
				if (distance < minDistance)
				{
					minDistance = distance;
					minIndex = i;
				}
			}
		}

		return minIndex;
	}

	private int getManhattanDistance(int r1, int c1, int r2, int c2)
	{
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	public static void main(String[] args)
	{
		FindNearestPointThatHasTheSameXorYCoordinate clazz = new FindNearestPointThatHasTheSameXorYCoordinate();

		System.out.println(clazz.nearestValidPoint(3, 4, new int[][]{
			{1, 2},
			{3, 1},
			{2, 4},
			{2, 3},
			{4, 4}
		}));

		System.out.println(clazz.nearestValidPoint(3, 4, new int[][]{
			{2, 3}
		}));
	}
}
