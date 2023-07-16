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
		for (int[] update : updates)
		{
			array[update[0]] += update[2];
			if (update[1] + 1 < length)
			{
				array[update[1] + 1] -= update[2];
			}
		}

		for (int i = 1; i < length; i++)
		{
			array[i] += array[i - 1];
		}

		return array;
	}
}
