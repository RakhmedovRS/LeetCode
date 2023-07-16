package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/18/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2376,
		name = "Count Special Integers",
		url = "https://leetcode.com/problems/count-special-integers/",
		difficulty = Difficulty.HARD
)
public class CountSpecialIntegers
{
	public int countSpecialNumbers(int n)
	{
		String val = "" + n;
		int len = val.length() - 1;
		int count;
		if (len == 0)
		{
			count = 0;
		}
		else
		{
			count = 9;
		}

		if (len > 1)
		{
			int unique = 9;
			for (int i = 1; i < len; i++)
			{
				unique *= (10 - i);
				count += unique;
			}
		}

		boolean[] used = new boolean[10];
		char[] chars = val.toCharArray();
		count += (chars[0] - '0' - 1) * fact(9) / fact(9 - chars.length + 1);
		used[chars[0] - '0'] = true;
		for (int i = 1; i < chars.length; i++)
		{
			int c = 0;
			for (int j = 0; j < (chars[i] - '0'); j++)
			{
				if (!used[j])
				{
					c++;
				}
			}
			count += c * fact(9 - i) / fact(9 - chars.length + 1);
			if (used[chars[i] - '0'])
			{
				break;
			}
			used[chars[i] - '0'] = true;
		}

		if (unique(n))
		{
			count += 1;
		}
		return count;
	}

	int fact(int n)
	{
		int result = 1;
		if (n > 9)
		{
			result = -1;
		}
		else if (n < 2)
		{
			result = 1;
		}
		else
		{
			for (int i = 2; i <= n; i++)
			{
				result *= i;
			}
		}

		return result;
	}

	boolean unique(int number)
	{
		boolean[] used = new boolean[10];
		int temp = number;
		while (temp > 0)
		{
			int digit = temp % 10;
			temp /= 10;
			if (used[digit])
			{
				return false;
			}

			used[digit] = true;
		}

		return true;
	}
}
