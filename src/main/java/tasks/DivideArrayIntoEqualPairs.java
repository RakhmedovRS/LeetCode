package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 3/19/2022
 */
@LeetCode(
		id = 2206,
		name = "Divide Array Into Equal Pairs",
		url = "https://leetcode.com/problems/divide-array-into-equal-pairs/",
		difficulty = Difficulty.EASY
)
public class DivideArrayIntoEqualPairs
{
	public boolean divideArray(int[] nums)
	{
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i += 2)
		{
			if (nums[i - 1] != nums[i])
			{
				return false;
			}
		}

		return true;
	}
}
