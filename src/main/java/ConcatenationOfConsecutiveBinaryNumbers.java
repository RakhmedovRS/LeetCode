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
		long result = 0;
		String binary;
		for (int i = 1; i <= n; i++)
		{
			binary = Integer.toBinaryString(i);
			for (int j = 0; j < binary.length(); j++)
			{
				result = (result * 2 + (binary.charAt(j) - '0')) % mod;
			}
		}

		return (int) result;
	}

	public static void main(String[] args)
	{
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(100_000));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(12));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(3));
		System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(1));
	}
}
