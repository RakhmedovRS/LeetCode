import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(id = 479, name = "Largest Palindrome Product", url = "https://leetcode.com/problems/largest-palindrome-product/")
public class LargestPalindromeProduct
{
	public int largestPalindrome(int n)
	{
		if (n == 1)
		{
			return 9;
		}
		long maxValue = (long) Math.pow(10, n);
		for (long a = maxValue - 1; a > maxValue / 10; a--)
		{
			long u = Long.parseLong(a + new StringBuilder().append(a).reverse().toString());
			for (long b = maxValue; b * b >= u; b--)
			{
				if (u % b == 0)
				{
					return (int) (u % 1337);
				}
			}
		}

		return 0;
	}
}
