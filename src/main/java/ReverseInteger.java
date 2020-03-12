/**
 * @author RakhmedovRS
 * @created 12-Mar-20
 */
@LeetCode(id = 7, name = "Reverse Integer", url = "https://leetcode.com/problems/reverse-integer/")
public class ReverseInteger
{
	public int reverse(int x)
	{
		if (x == Integer.MIN_VALUE)
		{
			return 0;
		}

		boolean negative = false;
		if (x < 0)
		{
			x *= -1;
			negative = true;
		}

		int currentLen = ("" + x).length();
		int divider = (int) Math.pow(10, currentLen - 1);

		int result = 0;
		while (x > 0)
		{
			result *= 10;
			result += x % 10;
			x /= 10;
			if (result > Integer.MAX_VALUE / divider)
			{
				return 0;
			}
			divider /= 10;
		}

		return negative ? result * -1 : result;
	}
}
