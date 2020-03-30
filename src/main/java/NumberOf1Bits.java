import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(id = 191, name = "Number of 1 Bits", url = "https://leetcode.com/problems/number-of-1-bits/")
public class NumberOf1Bits
{
	public int hammingWeight(int n)
	{
		int count = 0;
		for (int i = 0; i < 32; i++)
		{
			if ((n & 1) != 0)
			{
				count++;
			}
			n >>= 1;

		}
		return count;
	}
}
