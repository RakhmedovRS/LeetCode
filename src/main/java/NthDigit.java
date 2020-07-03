import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(id = 400, name = "Nth Digit", url = "https://leetcode.com/problems/nth-digit/")
public class NthDigit
{
	public int findNthDigit(int n)
	{
		if (n < 10)
		{
			return n;
		}

		int digits = 1;
		long current = 9;
		while (n - current > 0)
		{
			n -= current;
			digits++;
			current = 9 * digits * (int) Math.pow(10, digits - 1);
			if (current < 0)
			{
				break;
			}
		}

		long base = (long) Math.pow(10, digits - 1);
		long number = base + (n - 1) / digits;

		return String.valueOf(number).charAt((n - 1) % digits) - '0';
	}
}
