package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 28-Mar-20
 */
@LeetCode(id = 189, name = "Rotate Array", url = "https://leetcode.com/problems/rotate-array/")
public class RotateArray
{
	public void rotate(int[] nums, int k)
	{
		if (k == 0)
		{
			return;
		}

		k %= nums.length;
		reverseInRange(nums, 0, nums.length - 1);
		reverseInRange(nums, 0, k - 1);
		reverseInRange(nums, k, nums.length - 1);
	}

	private void reverseInRange(int[] nums, int start, int end)
	{
		int temp;
		while (start < end)
		{
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		new RotateArray().rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
}
