package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Sep-20
 */
@LeetCode(id = 1318, name = "Minimum Flips to Make a OR b Equal to c", url = "https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/")
public class MinimumFlipsToMakeORbEqualToc
{
	public int minFlips(int a, int b, int c)
	{
		int flips = 0;
		int cBit;
		for (int i = 31; i >= 0; i--)
		{
			cBit = (c & 1);
			if (cBit == 1)
			{
				flips += Math.abs(cBit - ((a & 1) == 1 ? 1 : (b & 1)));
			}
			else
			{
				flips += Math.abs(cBit - ((a & 1) + (b & 1)));
			}

			a >>= 1;
			b >>= 1;
			c >>= 1;
		}

		return flips;
	}
}
