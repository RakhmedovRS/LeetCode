package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 12/5/2021
 */
@LeetCode(
	id = 2094,
	name = "Finding 3-Digit Even Numbers",
	url = "https://leetcode.com/problems/finding-3-digit-even-numbers/",
	difficulty = Difficulty.EASY
)
public class FindingTreeDigitEvenNumbers
{
	public int[] findEvenNumbers(int[] digits)
	{
		Set<Integer> set = new HashSet<>();
		for (int a = 0; a < digits.length; a++)
		{
			if (digits[a] == 0)
			{
				continue;
			}

			for (int b = 0; b < digits.length; b++)
			{
				if (a == b)
				{
					continue;
				}
				for (int c = 0; c < digits.length; c++)
				{
					if (a == c || b == c)
					{
						continue;
					}

					int val = digits[a] * 100 + digits[b] * 10 + digits[c];
					if (val % 2 == 0)
					{
						set.add(val);
					}
				}
			}
		}

		int i = 0;
		int[] arr = new int[set.size()];
		for (Integer val : set)
		{
			arr[i++] = val;
		}

		Arrays.sort(arr);
		return arr;
	}
}
