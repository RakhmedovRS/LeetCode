package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/17/2021
 */
@LeetCode(
		id = 866,
		name = "Prime Palindrome",
		url = "https://leetcode.com/problems/prime-palindrome/",
		difficulty = Difficulty.MEDIUM
)
public class PrimePalindrome {
	public int primePalindrome(int N) {
		while (true) {
			if (isPrime(N) && N == reverseNumber(N)) {
				return N;
			}
			N++;
			if (10_000_000 < N && N < 100_000_000) {
				N = 100_000_000;
			}
		}
	}

	private boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		int root = (int) Math.sqrt(number);
		for (int i = 2; i <= root; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	private int reverseNumber(int number) {
		int num = 0;
		while (number > 0) {
			num *= 10;
			num += number % 10;
			number /= 10;
		}
		return num;
	}

	public static void main(String[] args) {
		PrimePalindrome clazz = new PrimePalindrome();
		System.out.println(clazz.primePalindrome(8));
	}
}
