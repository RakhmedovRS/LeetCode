package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/15/2020
 */
@LeetCode(
	id = 1073,
	name = "Adding Two Negabinary Numbers",
	url = "https://leetcode.com/problems/adding-two-negabinary-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class AddingTwoNegabinaryNumbers
{
	public int[] addNegabinary(int[] arr1, int[] arr2)
	{
		if (arr1.length == 0)
		{
			return arr2;
		}

		if (arr2.length == 0)
		{
			return arr1;
		}

		int max = Math.max(arr1.length, arr2.length) + 2;
		int[] a = new int[max];
		int[] b = new int[max];
		int[] temp = new int[max];
		int aPos = arr1.length - 1;
		int bPos = arr2.length - 1;
		for (int i = max - 1; i >= 0; i--)
		{
			if (aPos >= 0)
			{
				a[i] = arr1[aPos--];
			}

			if (bPos >= 0)
			{
				b[i] = arr2[bPos--];
			}
		}

		int carry = 0;
		for (int i = max - 1; i >= 0; i--)
		{
			carry += a[i] + b[i];
			temp[i] = Math.abs(carry) % 2;
			if (carry > 1)
			{
				carry = -1;
			}
			else if (carry < 0)
			{
				carry = 1;
			}
			else
			{
				carry = 0;
			}
		}

		int i = 0;
		for (; i < max; i++)
		{
			if (temp[i] != 0)
			{
				break;
			}
		}

		if (i == max)
		{
			return new int[1];
		}

		int[] answer = new int[max - i];
		for (int j = 0; i < max; i++, j++)
		{
			answer[j] = temp[i];
		}

		return answer;
	}
}
