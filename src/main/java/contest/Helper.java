package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/20/2022
 */
public final class Helper {
	public static long powerMod(long base, long exp, long mod) {
		long result = 1;
		base %= mod;
		while (exp > 0) {
			if ((exp & 1) != 0) {
				result = (result * base) % mod;
			}
			exp >>= 1;
			base = base * base % mod;
		}
		return result < 0 ? result + mod : result;
	}

	public static long factorialMod(int num, int mod) {
		if (num >= mod) {
			return 0;
		}

		int result = 1;
		for (int i = 1; i <= num; i++) {
			result = (result * i) % mod;
		}

		return result;
	}

	public static int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}

	public static int manhattanDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static int euclideanDistance(int[] a, int[] b) {
		double xDiff = a[0] - b[0];
		double yDiff = a[1] - b[1];
		return (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public static List<int[]> getCommonDivisors(int k) {
		List<int[]> answer = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(k - 1); i++) {
			if (k % i == 0) {
				if (k / i == i) {
					answer.add(new int[]{i, i});
				}
				else {
					answer.add(new int[]{i, k / i});
				}
			}
		}

		return answer;
	}

	public static int gcd(int a, int b) {
		return a == 0 ? b : gcd(b % a, a);
	}

	public static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

	public static boolean isPalindrome(char[] chars, int left, int right) {
		while (left <= right) {
			if (chars[left++] != chars[right--]) {
				return false;
			}
		}
		return true;
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

	public static List<Integer> generatePalindromes(int length) {
		List<Integer> palindromes = new ArrayList<>();
		if (length == 1) {
			for (int i = 0; i < 10; i++) {
				palindromes.add(i);
			}
			return palindromes;
		}

		int left = 1;
		if (length % 2 == 0) {
			for (int i = 1; i < length / 2; i++) {
				left *= 10;
				left += 1;
			}

			while (numberLength(left) == length / 2) {
				int val = left;
				int temp = left;
				while (temp > 0) {
					val *= 10;
					val += temp % 10;
					temp /= 10;
				}

				palindromes.add(val);
				left++;
			}
		}
		else {
			for (int i = 1; i < length / 2; i++) {
				left *= 10;
				left += 1;
			}

			while (numberLength(left) == length / 2) {
				for (int v = 0; v < 10; v++) {
					int val = left;
					int temp = left;

					val *= 10;
					val += v;
					while (temp > 0) {
						val *= 10;
						val += temp % 10;
						temp /= 10;
					}

					palindromes.add(val);
				}
				left++;
			}
		}

		return palindromes;
	}

	public static int numberLength(long val) {
		int len = 0;
		while (val > 0) {
			val /= 10;
			len++;
		}

		return len;
	}
}
