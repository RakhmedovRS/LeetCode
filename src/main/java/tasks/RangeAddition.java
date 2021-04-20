package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/14/2021
 */
@LeetCode(
	id = 370,
	name = "Range Addition",
	url = "https://leetcode.com/problems/range-addition/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class RangeAddition
{
	public int[] getModifiedArray(int length, int[][] updates)
	{
		int[] array = new int[length];
		int start;
		int end;
		int value;
		for (int[] update : updates)
		{
			start = update[0];
			end = update[1] + 1;
			value = update[2];

			array[start] += value;
			if (end < length)
			{
				array[end] -= value;
			}
		}

		for (int i = 1; i < length; i++)
		{
			array[i] += array[i - 1];
		}

		return array;
	}
}
