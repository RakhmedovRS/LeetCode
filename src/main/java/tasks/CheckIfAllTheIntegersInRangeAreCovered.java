package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/13/2021
 */
@LeetCode(
	id = 1893,
	name = "Check if All the Integers in a Range Are Covered",
	url = "https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/",
	difficulty = Difficulty.EASY
)
public class CheckIfAllTheIntegersInRangeAreCovered
{
	public boolean isCovered(int[][] ranges, int left, int right)
	{
		boolean[] xLine = new boolean[51];
		for (int[] range : ranges)
		{
			while (range[0] <= range[1])
			{
				xLine[range[0]] = true;

				range[0]++;
			}
		}
		while (left <= right)
		{
			if (!xLine[left++])
			{
				return false;
			}
		}

		return true;
	}
}
