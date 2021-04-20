package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Aug-20
 */
@LeetCode(id = 313, name = "Super Ugly Number", url = "https://leetcode.com/problems/super-ugly-number/")
public class SuperUglyNumber
{
	public int nthSuperUglyNumber(int n, int[] primes)
	{
		int[] uglies = new int[n];
		int[] indices = new int[primes.length];
		uglies[0] = 1;
		for (int i = 1; i < uglies.length; i++)
		{
			uglies[i] = Integer.MAX_VALUE;
			for (int pos = 0; pos < primes.length; pos++)
			{
				uglies[i] = Math.min(uglies[i], primes[pos] * uglies[indices[pos]]);
			}

			for (int pos = 0; pos < primes.length; pos++)
			{
				while (primes[pos] * uglies[indices[pos]] <= uglies[i])
				{
					indices[pos]++;
				}
			}
		}

		return uglies[n - 1];
	}
}
