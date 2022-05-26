package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(
	id = 1356,
	name = "Sort Integers by The Number of 1 Bits",
	url = "https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/",
	difficulty = Difficulty.EASY
)
public class SortIntegersByTheNumberOf1Bits
{
	public int[] sortByBits(int[] arr)
	{
		Integer[] temp = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		Arrays.sort(temp, (a, b) ->
		{
			int diff = Integer.bitCount(a) - Integer.bitCount(b);
			return diff == 0 ? a - b : diff;
		});

		for (int i = 0; i < temp.length; i++)
		{
			arr[i] = temp[i];
		}
		return arr;
	}
}
