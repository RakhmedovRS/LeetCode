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
		if (nums == null || nums.length == 0 || k <= 0)
		{
			return;
		}

		int sampleCounter = 0;
		int[] sample = Arrays.copyOf(nums, nums.length);
		k = k % nums.length;
		for (int i = k; i < sample.length; i++)
		{
			nums[i] = sample[sampleCounter++];
		}

		for (int i = 0; i < k; i++)
		{
			nums[i] = sample[sampleCounter++];
		}
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		new RotateArray().rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
}
