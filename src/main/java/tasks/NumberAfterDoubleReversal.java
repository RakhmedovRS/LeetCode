package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/26/2021
 */
@LeetCode(
		id = 2119,
		name = "A Number After a Double Reversal",
		url = "https://leetcode.com/problems/a-number-after-a-double-reversal/",
		difficulty = Difficulty.EASY
)
public class NumberAfterDoubleReversal
{
	public boolean isSameAfterReversals(int num)
	{
		return num == reverse(reverse(num));
	}

	public int reverse(int x)
	{
		long value = 0;
		while (x != 0)
		{
			value *= 10;
			value += x % 10;
			x /= 10;
		}

		if (Math.abs(value) > Integer.MAX_VALUE)
		{
			return 0;
		}

		return (int) (value);
	}
}
