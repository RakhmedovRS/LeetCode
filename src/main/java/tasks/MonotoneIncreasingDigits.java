package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/15/2020
 */
@LeetCode(id = 738, name = "Monotone Increasing Digits", url = "https://leetcode.com/problems/monotone-increasing-digits/")
public class MonotoneIncreasingDigits
{
	public int monotoneIncreasingDigits(int N)
	{
		if (N == 0)
		{
			return 0;
		}
		else if (N <= 10)
		{
			return N - 1;
		}

		int[] digits = parseNumber(N);

		if (isMonotoneIncreasing(digits))
		{
			return N;
		}

		for (int i = 1; i < digits.length; i++)
		{
			if (digits[i - 1] > digits[i])
			{
				digits[i]--;
				for (int j = i + 1; j < digits.length; j++)
				{
					digits[j] = 9;
				}

				while (!isMonotoneIncreasing(digits))
				{
					digits[i] = 9;
					digits[i - 1]--;
					i--;
				}

				break;
			}
		}

		return rebuildNumber(digits);
	}

	private boolean isMonotoneIncreasing(int[] digits)
	{
		for (int i = 1; i < digits.length; i++)
		{
			if (digits[i - 1] > digits[i])
			{
				return false;
			}
		}

		return true;
	}

	private int[] parseNumber(int number)
	{
		int temp = number;
		int count = 0;
		while (temp > 0)
		{
			temp /= 10;
			count++;
		}

		int[] digits = new int[count];
		for (int i = count - 1; i >= 0; i--)
		{
			digits[i] = number % 10;
			number /= 10;
		}
		return digits;
	}

	private int rebuildNumber(int[] digits)
	{
		int number = 0;
		for (int digit : digits)
		{
			number *= 10;
			number += digit;
		}
		return number;
	}
}
