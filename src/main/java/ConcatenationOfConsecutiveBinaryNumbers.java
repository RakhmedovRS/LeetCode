import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/6/2020
 */
@LeetCode(
	id = 1680,
	name = "Concatenation of Consecutive Binary Numbers",
	url = "https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class ConcatenationOfConsecutiveBinaryNumbers
{
	public int concatenatedBinary(int n)
	{
		int mod = 1_000_000_007;
		int result = 0;
		for (int i = 1; i <= n; i++)
		{
			for(char bit : Integer.toBinaryString(i).toCharArray())
			{
				result = (result * 2 + (bit - '0')) % mod;
			}

		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(100_000));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(12));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(3));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(1));
	}
}
