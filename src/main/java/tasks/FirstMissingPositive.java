package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
@LeetCode(
	id = 41,
	name = "First Missing Positive",
	url = "https://leetcode.com/problems/first-missing-positive/",
	difficulty = Difficulty.HARD
)
public class FirstMissingPositive
{
	public int firstMissingPositive(int[] nums)
	{
		if (nums.length == 0)
		{
			return 1;
		}

		for (int i = 0; i < nums.length;)
		{
			int num = nums[i];
			int pos = num - 1;
			if (0 <= pos && pos < nums.length && nums[pos] != num)
			{
				swap(nums, i, pos);
			}
			else
			{
				i++;
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != i + 1)
			{
				return i + 1;
			}
		}

		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args)
	{
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{})); //1
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1})); //2
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2})); //1
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10})); //3
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1})); //2
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2, 1})); //3
		System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1, 1})); //2
	}
}
