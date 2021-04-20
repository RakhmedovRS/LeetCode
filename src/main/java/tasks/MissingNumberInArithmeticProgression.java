package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
	id = 1228,
	name = "Missing Number In Arithmetic Progression",
	url = "https://leetcode.com/problems/missing-number-in-arithmetic-progression/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class MissingNumberInArithmeticProgression
{
	public int missingNumber(int[] arr)
	{
		int first = arr[0];
		int last = arr[0];
		int sum = 0;
		for (int num : arr)
		{
			first = Math.min(first, num);
			last = Math.max(last, num);
			sum += num;
		}

		return (first + last) * (arr.length + 1) / 2 - sum;
	}
}
