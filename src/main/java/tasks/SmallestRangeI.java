package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(
	id = 908,
	name = "Smallest Range I",
	url = "https://leetcode.com/problems/smallest-range-i/",
	difficulty = Difficulty.EASY
)
public class SmallestRangeI
{
	public int smallestRangeI(int[] A, int K)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : A)
		{
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		min += K;
		max -= K;

		return min >= max ? 0 : max - min;
	}
}
