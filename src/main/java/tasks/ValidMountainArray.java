package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(
		id = 941,
		name = "Valid Mountain Array",
		url = "https://leetcode.com/problems/valid-mountain-array/",
		difficulty = Difficulty.EASY
)
public class ValidMountainArray
{
	public boolean validMountainArray(int[] arr)
	{
		int[] leftToRight = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			if (i != 0 && arr[i - 1] < arr[i])
			{
				leftToRight[i] = leftToRight[i - 1] + 1;
			}
			else
			{
				leftToRight[i] = 1;
			}
		}

		int[] rightToLeft = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--)
		{
			if (i != arr.length - 1 && arr[i] > arr[i + 1])
			{
				rightToLeft[i] = rightToLeft[i + 1] + 1;
			}
			else
			{
				rightToLeft[i] = 1;
			}
		}

		for (int i = 1; i < arr.length - 1; i++)
		{
			if (leftToRight[i] == i + 1 && rightToLeft[i] == arr.length - i)
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new ValidMountainArray().validMountainArray(new int[]{0, 3, 2, 1}));
		System.out.println(new ValidMountainArray().validMountainArray(new int[]{3, 5, 5}));
	}
}
