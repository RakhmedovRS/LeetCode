package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/7/2021
 */
@LeetCode(
	id = 1752,
	name = "Check if Array Is Sorted and Rotated",
	url = "https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/",
	difficulty = Difficulty.EASY
)
public class CheckIfArrayIsSortedAndRotated
{
	public boolean check(int[] nums)
	{
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		outer:
		for (int pos = 0; pos < nums.length; pos++)
		{
			if (copy[0] == nums[pos])
			{
				for (int i = 0, j = pos; i < nums.length; i++, j++)
				{
					if (copy[i] != nums[j % nums.length])
					{
						continue outer;
					}
				}
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		CheckIfArrayIsSortedAndRotated clazz = new CheckIfArrayIsSortedAndRotated();
		System.out.println(clazz.check(new int[]{6, 10, 6}));
		System.out.println(clazz.check(new int[]{3, 4, 5, 1, 2}));
	}
}
