import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(id = 8, name = "String to Integer", url = "https://leetcode.com/problems/string-to-integer-atoi/")
public class StringToInteger
{
	public int myAtoi(String str)
	{
		int idx = 0;
		while (idx < str.length() && str.charAt(idx) == ' ')
		{
			idx++;
		}
		if (idx == str.length())
		{
			return 0;
		}

		boolean negative = false;
		if (str.charAt(idx) == '-')
		{
			negative = true;
			idx++;
		}
		else if (str.charAt(idx) == '+')
		{
			idx++;
		}

		if (idx == str.length())
		{
			return 0;
		}

		long result = 0;
		while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9')
		{
			result *= 10;
			if (negative)
			{
				result -= str.charAt(idx) - '0';
			}
			else
			{
				result += str.charAt(idx) - '0';
			}

			if (!negative && result > Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}

			if (negative && result < Integer.MIN_VALUE)
			{
				return Integer.MIN_VALUE;
			}
			idx++;
		}

		return (int) result;
	}

	public static void main(String[] args)
	{
		System.out.println(new StringToInteger().myAtoi("+-1"));
	}
}
