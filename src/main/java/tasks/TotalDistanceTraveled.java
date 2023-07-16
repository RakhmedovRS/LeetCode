package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 6/18/2023
 */
@LeetCode(
		id = 2739,
		name = "Total Distance Traveled",
		url = "https://leetcode.com/problems/total-distance-traveled/",
		difficulty = Difficulty.EASY
)
public class TotalDistanceTraveled
{
	public int distanceTraveled(int mainTank, int additionalTank)
	{
		int res = 0;
		while (mainTank > 0)
		{
			if (mainTank / 5 > 0 && additionalTank > 0)
			{
				res += 50;
				mainTank -= 4;
				additionalTank -= 1;
			}
			else
			{
				res += 10;
				mainTank -= 1;
			}
		}

		return res;
	}
}
