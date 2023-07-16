package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/19/2022
 */
@LeetCode(
		id = 2176,
		name = "Count Equal and Divisible Pairs in an Array",
		url = "https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/",
		difficulty = Difficulty.EASY
)
public class CountEqualAndDivisiblePairsInArray
{
	public int countPairs(int[] nums, int k)
	{
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				if (nums[i] == nums[j] && i * j % k == 0)
				{
					count++;
				}
			}
		}

		return count;
	}
}
