import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/29/2020
 */
@LeetCode(id = 1015, name = "Smallest Integer Divisible by K", url = "https://leetcode.com/problems/smallest-integer-divisible-by-k/")
public class SmallestIntegerDivisibleByK
{
	public int smallestRepunitDivByK(int K)
	{
		int reminder = 0;
		for (int len = 1; len <= K; len++)
		{
			reminder = (reminder * 10 + 1) % K;
			if (reminder == 0)
			{
				return len;
			}
		}

		return -1;
	}
}
