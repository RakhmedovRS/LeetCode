package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/7/2021
 */
@LeetCode(
		id = 1748,
		name = "Sum of Unique Elements",
		url = "https://leetcode.com/problems/sum-of-unique-elements/",
		difficulty = Difficulty.EASY
)
public class SumOfUniqueElements
{
	public int sumOfUnique(int[] nums)
	{
		int[] memo = new int[101];
		for (int num : nums)
		{
			memo[num]++;
		}

		int sum = 0;
		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i] == 1)
			{
				sum += i;
			}
		}

		return sum;
	}
}
