package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/17/2020
 */
@LeetCode(id = 1620, name = "Coordinate With Maximum Network Quality", url = "https://leetcode.com/problems/coordinate-with-maximum-network-quality/")
public class CoordinateWithMaximumNetworkQuality
{
	public int[] bestCoordinate(int[][] towers, int radius)
	{
		double max = Integer.MIN_VALUE;
		int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
		int current = 0;
		double distance;
		for (int i = 0; i < towers.length; i++)
		{
			current = 0;
			for (int j = 0; j < towers.length; j++)
			{
				if (i == j)
				{
					continue;
				}

				distance = getDistance(towers[i], towers[j]);
				if (distance <= radius)
				{
					current += (int) (towers[j][2] / (1 + distance));
				}
			}

			current += towers[i][2];
			if (current > max)
			{
				answer = new int[]{towers[i][0], towers[i][1]};
				max = current;
			}
			else if (current == max)
			{
				if (answer[0] > towers[i][0] || (answer[0] == towers[i][0] && answer[1] > towers[i][1]))
				{
					answer = new int[]{towers[i][0], towers[i][1]};
				}
			}
		}

		return answer;
	}

	private double getDistance(int[] a, int[] b)
	{
		return Math.sqrt((Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2)));
	}
}
