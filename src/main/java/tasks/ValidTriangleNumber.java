package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 7/15/2021
 */
@LeetCode(
	id = 611,
	name = "Valid Triangle Number",
	url = "https://leetcode.com/problems/valid-triangle-number/",
	difficulty = Difficulty.MEDIUM
)
public class ValidTriangleNumber
{
	public int triangleNumber(int[] nums)
	{
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++)
		{
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++)
			{
				while (k < nums.length && nums[i] + nums[j] > nums[k])
				{
					k++;
				}
				count += k - j - 1;
			}
		}
		return count;
	}
}
