package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(id = 1317, name = "Convert Integer to the Sum of Two No-Zero Integers", url = "https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/")
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers
{
	private boolean containsZero(int n)
	{
		while (n > 0)
		{
			if (n % 10 == 0)
			{
				return true;
			}
			n /= 10;
		}
		return false;
	}

	public int[] getNoZeroIntegers(int n)
	{
		for (int i = 1; i < n; i++)
		{
			if (!containsZero(n - i) && !containsZero(i))
			{
				return new int[]{i, n - i};
			}
		}

		return new int[]{1, 1};
	}
}
