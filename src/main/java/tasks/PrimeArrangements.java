package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(id = 1175, name = "Prime Arrangements", url = "https://leetcode.com/problems/prime-arrangements/")
public class PrimeArrangements {
	private final int MOD = (int) (Math.pow(10, 9) + 7);

	public int numPrimeArrangements(int n) {
		int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		int i = 0;
		while (i < primes.length && primes[i] <= n) {
			i++;
		}

		return (int) (factorial(i) % MOD * factorial((n - i)) % MOD) % MOD;
	}

	private long factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1) % MOD;
	}
}
