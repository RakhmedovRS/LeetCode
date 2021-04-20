package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 172, name = "Factorial Trailing Zeroes", url = "https://leetcode.com/problems/factorial-trailing-zeroes/")
public class FactorialTrailingZeroes
{
	public int trailingZeroes(int n)
	{
		int cnt = 0;
		while (n > 0)
		{
			cnt += n / 5;
			n /= 5;
		}
		return cnt;
	}

	public static void main(String[] args)
	{
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(30));
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(15));
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(3));
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(5));
	}
}
