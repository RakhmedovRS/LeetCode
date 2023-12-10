package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(id = 762, name = "Prime Number of Set Bits in Binary Representation", url = "https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/")
public class PrimeNumberOfSetBitsInBinaryRepresentation {
	private boolean[] getPrimes() {
		boolean[] primes = new boolean[33];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < primes.length; i++) {
			int pos = i + i;
			while (pos < primes.length) {
				primes[pos] = false;
				pos += i;
			}
		}
		return primes;
	}

	public int countPrimeSetBits(int L, int R) {
		int counter = 0;
		boolean[] primes = getPrimes();
		for (; L <= R; L++) {
			if (primes[Integer.bitCount(L)]) {
				counter++;
			}
		}

		return counter;
	}

	public static void main(String[] args) {
		System.out.println(new PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(10, 15));
	}
}
