package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/24/2022
 */
@LeetCode(
		id = 2249,
		name = "Count Lattice Points Inside a Circle",
		url = "https://leetcode.com/problems/count-lattice-points-inside-a-circle/",
		difficulty = Difficulty.MEDIUM
)
public class CountLatticePointsInsideCircle
{
	public int countLatticePoints(int[][] circles)
	{
		int count = 0;
		boolean[][] grid = new boolean[1001][1001];
		for (int[] circle : circles)
		{
			int circleX = circle[0];
			int circleY = circle[1];
			int radius = circle[2];
			for (int x = circleX - radius; x <= circleX + radius; x++)
			{
				for (int y = circleY - radius; y <= circleY + radius; y++)
				{
					if (pointInsideCircle(circleX, circleY, radius, x, y))
					{
						if (!grid[x][y])
						{
							grid[x][y] = true;
							count++;
						}
					}
				}
			}
		}

		return count;
	}

	boolean pointInsideCircle(int circleX, int circleY,
							  int radius, int pointX, int pointY)
	{
		if ((pointX - circleX) * (pointX - circleX) +
				(pointY - circleY) * (pointY - circleY) <= radius * radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
