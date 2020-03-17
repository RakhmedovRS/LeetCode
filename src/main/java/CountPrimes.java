import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 204, name = "Count Primes", url = "https://leetcode.com/problems/count-primes/")
public class CountPrimes
{
	public int countPrimes(int n)
	{
		if (n <= 2)
		{
			return 0;
		}

		boolean[] memo = new boolean[n];
		Arrays.fill(memo, true);
		memo[0] = false;
		memo[1] = false;

		for (int factor = 2; factor < memo.length; factor++)
		{
			if (!memo[factor])
			{
				continue;
			}

			for (int i = 2; i * factor < memo.length; i++)
			{
				memo[i * factor] = false;
			}
		}

		int counter = 0;
		for (boolean state : memo)
		{
			if (state)
			{
				counter++;
			}
		}

		return counter;
	}

	public static void main(String[] args)
	{
		System.out.println(new CountPrimes().countPrimes(10));;
	}
}
