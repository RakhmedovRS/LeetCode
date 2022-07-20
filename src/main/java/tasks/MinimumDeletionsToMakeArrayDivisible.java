package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 7/20/2022
 */
@LeetCode(
	id = 2344,
	name = "Minimum Deletions to Make Array Divisible",
	url = "https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/",
	difficulty = Difficulty.HARD
)
public class MinimumDeletionsToMakeArrayDivisible
{
	public int minOperations(int[] nums, int[] numsDivide)
	{
		Arrays.sort(numsDivide);
		int lcd = lcd(numsDivide[0], numsDivide[numsDivide.length - 1]);
		for (int i = 1; i < numsDivide.length; i++)
		{
			lcd = Math.min(lcd, lcd(numsDivide[i - 1], numsDivide[i]));
		}

		for (int i = 1; i < numsDivide.length; i++)
		{
			if (numsDivide[i] % lcd != 0)
			{
				return -1;
			}
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++)
		{
			if (lcd % nums[i] == 0)
			{
				return i;
			}
		}

		return -1;
	}

	private int lcd(int a, int b)
	{
		if (a == 0)
		{
			return b;
		}
		return lcd(b % a, a);
	}
}
