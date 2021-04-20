package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(id = 190, name = "Reverse Bits", url = "https://leetcode.com/problems/reverse-bits/")
public class ReverseBits
{
	public int reverseBits(long n)
	{
		int result = 0;
		for (int i = 0; i < 32; i++)
		{
			result <<= 1;
			if ((n & 1) != 0)
			{
				result |= 1;
			}

			n >>= 1;
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new ReverseBits().reverseBits(43261596));
		System.out.println(new ReverseBits().reverseBits(4294967293L));
	}
}
