package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 8/15/2021
 */
@LeetCode(
		id = 1968,
		name = "Array With Elements Not Equal to Average of Neighbors",
		url = "https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/",
		difficulty = Difficulty.MEDIUM
)
public class ArrayWithElementsNotEqualToAverageOfNeighbors
{
	public int[] rearrangeArray(int[] nums)
	{
		Arrays.sort(nums);
		int[] answer = new int[nums.length];

		int left = 0;
		int right = nums.length - 1;
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				answer[i] = nums[left++];
			}
			else
			{
				answer[i] = nums[right--];
			}
		}

		return answer;
	}
}
