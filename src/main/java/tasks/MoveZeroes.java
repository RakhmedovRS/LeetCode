package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
@LeetCode(id = 283, name = "Move Zeroes", url = "https://leetcode.com/problems/move-zeroes/")
public class MoveZeroes
{
	public void moveZeroes(int[] nums)
	{
		if (nums == null || nums.length <= 1)
		{
			return;
		}

		int left = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != 0)
			{
				nums[left++] = nums[i];
			}
		}

		for (; left < nums.length; left++)
		{
			nums[left] = 0;
		}
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{0,1,0,3,12};
		new MoveZeroes().moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
}
