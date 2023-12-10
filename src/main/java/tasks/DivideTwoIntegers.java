package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(
		id = 29,
		name = "Divide Two Integers",
		url = "https://leetcode.com/problems/divide-two-integers/",
		difficulty = Difficulty.MEDIUM
)
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		return (int) divideL(dividend, divisor);
	}

	public long divideL(long dividend, long divisor) {
		boolean negative = false;
		if (dividend < 0) {
			dividend = -dividend;
			negative = true;
		}

		if (divisor < 0) {
			divisor = -divisor;
			negative = !negative;
		}

		if (dividend < divisor) {
			return 0;
		}

		int count = 1;
		long div = divisor;

		while (div << 1 <= dividend) {
			count <<= 1;
			div <<= 1;
		}

		long res = count + divideL(dividend - div, divisor);
		return negative ? -1 * res : res;
	}

	public static void main(String[] args) {
		System.out.println(new DivideTwoIntegers().divide(-2147483648, 2));
		System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
		System.out.println(new DivideTwoIntegers().divide(7, -3));
		System.out.println(new DivideTwoIntegers().divide(-1, -1));
		System.out.println(new DivideTwoIntegers().divide(700, 3));
	}
}
