package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/20/2022
 */
@LeetCode(
		id = 2211,
		name = "Count Collisions on a Road",
		url = "https://leetcode.com/problems/count-collisions-on-a-road/",
		difficulty = Difficulty.MEDIUM
)
public class CountCollisionsOnRoad
{
	public int countCollisions(String directions)
	{
		int collisions = 0;
		char[] chars = directions.toCharArray();
		boolean seenObstacle = false;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == 'L')
			{
				if (seenObstacle)
				{
					collisions++;
				}
			}
			else
			{
				seenObstacle = true;
			}
		}

		seenObstacle = false;
		for (int i = chars.length - 1; i >= 0; i--)
		{
			if (chars[i] == 'R')
			{
				if (seenObstacle)
				{
					collisions++;
				}
			}
			else
			{
				seenObstacle = true;
			}
		}

		return collisions;
	}
}
