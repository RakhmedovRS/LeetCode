package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(
		id = 204,
		name = "Count Primes",
		url = "https://leetcode.com/problems/count-primes/",
		difficulty = Difficulty.EASY
)
public class CountPrimes {
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}

		int count = 0;
		boolean[] primes = new boolean[n];

		for (int i = 2; i < primes.length; i++) {
			if (!primes[i]) {
				count++;
				for (int j = i * 2; j > 0 && j < primes.length; j += i) {
					primes[j] = true;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes(10));
	}
}
