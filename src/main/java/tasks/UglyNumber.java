package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(id = 263, name = "Ugly Number", url = "https://leetcode.com/problems/ugly-number/")
public class UglyNumber
{
	public boolean isUgly(int num)
	{
		return getPrimes(num).contains((long)num);
	}

	private Set<Long> getPrimes(long number)
	{
		number = Math.abs(number);
		Set<Long> ugly = new HashSet<>();
		ugly.add(1L);
		List<Long> primes = new ArrayList<>();
		primes.add(1L);
		int two = 0;
		int three = 0;
		int five = 0;
		long prime = 0;
		while (prime <= number)
		{
			prime = Math.min(primes.get(two) * 2, Math.min(primes.get(three) * 3, primes.get(five) * 5));
			primes.add(prime);
			two += prime == primes.get(two) * 2 ? 1 : 0;
			three += prime == primes.get(three) * 3 ? 1 : 0;
			five += prime == primes.get(five) * 5 ? 1 : 0;
		}

		ugly.addAll(primes);

		return ugly;
	}

	public static void main(String[] args)
	{
		System.out.println(new UglyNumber().isUgly(6));
		System.out.println(new UglyNumber().isUgly(Integer.MIN_VALUE));
		System.out.println(new UglyNumber().isUgly(8));
	}
}
