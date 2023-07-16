package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/23/2022
 */
@LeetCode(
		id = 2148,
		name = "Count Elements With Strictly Smaller and Greater Elements",
		url = "https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/",
		difficulty = Difficulty.EASY
)
public class CountElementsWithStrictlySmallerAndGreaterElements
{
	public int countElements(int[] nums)
	{
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] > nums[0] && nums[i] < nums[nums.length - 1])
			{
				count++;
			}
		}

		return count;
	}
}
