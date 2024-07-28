package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-27
 */
@LeetCode(
		id = 3233,
		name = "Find the Count of Numbers Which Are Not Special",
		url = "https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheCountOfNumbersWhichAreNotSpecial {
	public int nonSpecialCount(int l, int r) {
		List<Integer> primes = getPrimes((int)Math.sqrt(r));
		int ans = 1 + r - l;
		for (int prime : primes) {
			long primeD = (long) prime * prime;
			if (l <= primeD && primeD <= r) {
				ans--;
			}
		}
		return ans;
	}

	public static List<Integer> getPrimes(int maxValue) {
		boolean[] sieveOfEratosthenes = new boolean[maxValue + 1];
		Arrays.fill(sieveOfEratosthenes, true);

		for (int num1 = 2; num1 * num1 <= maxValue; num1++) {
			if (sieveOfEratosthenes[num1]) {
				for (int num2 = num1 * num1; num2 <= maxValue; num2 += num1) {
					sieveOfEratosthenes[num2] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < sieveOfEratosthenes.length; i++) {
			if (sieveOfEratosthenes[i]) {
				primes.add(i);
			}
		}

		return primes;
	}
}