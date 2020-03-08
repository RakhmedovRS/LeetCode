/**
 * Binary Number with Alternating Bits
 * LeetCode 693
 *
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
public class BinaryNumberWithAlternatingBits
{
	public boolean hasAlternatingBits(int n)
	{
		StringBuilder cache = new StringBuilder(32);
		while (n > 0)
		{
			if ((n & 1) != 0)
			{
				cache.append('1');
			}
			else
			{
				cache.append('0');
			}
			n = n >> 1;
		}

		for (int i = 1; i <= cache.length() - 1; i++)
		{
			if (cache.charAt(i) == cache.charAt(i - 1))
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(4));
	}
}
