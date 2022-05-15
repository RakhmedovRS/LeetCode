package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/15/2022
 */
@LeetCode(
	id = 2274,
	name = "Maximum Consecutive Floors Without Special Floors",
	url = "https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumConsecutiveFloorsWithoutSpecialFloors
{
	public int maxConsecutive(int bottom, int top, int[] special)
	{
		int max = 0;
		Arrays.sort(special);
		max = Math.max(max, special[0] - bottom);
		for (int i = 1; i < special.length; i++)
		{
			max = Math.max(max, special[i] - special[i - 1] - 1);
		}

		max = Math.max(max, top - special[special.length - 1]);

		return max;
	}
}
