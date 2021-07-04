package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/4/2021
 */
@LeetCode(
	id = 1920,
	name = "Build Array from Permutation",
	url = "https://leetcode.com/problems/build-array-from-permutation/",
	difficulty = Difficulty.EASY
)
public class BuildArrayFromPermutation
{
	public int[] buildArray(int[] nums)
	{
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			answer[i] = nums[nums[i]];
		}

		return answer;
	}
}
