package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-Aug-20
 */
@LeetCode(id = 1014, name = "Best Sightseeing Pair", url = "https://leetcode.com/problems/best-sightseeing-pair/")
public class BestSightseeingPair
{
	public int maxScoreSightseeingPair(int[] A)
	{
		int max = 0;
		int current = 0;
		for (int a : A)
		{
			max = Math.max(max, current + a);
			current = Math.max(current, a) - 1;
		}

		return max;
	}
}
