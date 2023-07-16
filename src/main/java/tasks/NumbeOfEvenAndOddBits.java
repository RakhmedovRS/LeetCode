package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/22/2023
 */
@LeetCode(
		id = 2595,
		name = "Number of Even and Odd Bits",
		url = "https://leetcode.com/problems/number-of-even-and-odd-bits/",
		difficulty = Difficulty.EASY
)
public class NumbeOfEvenAndOddBits
{
	public int[] evenOddBit(int n)
	{
		int even = 0;
		int odd = 0;

		boolean ev = true;
		String bits = Integer.toBinaryString(n);
		for (int i = bits.length() - 1; i >= 0; i--)
		{
			if (bits.charAt(i) == '1')
			{
				if (ev)
				{
					even++;
				}
				else
				{
					odd++;
				}
			}

			ev = !ev;
		}

		return new int[]{even, odd};
	}
}
