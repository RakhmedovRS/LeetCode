package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/17/2022
 */
@LeetCode(
		id = 2165,
		name = "Smallest Value of the Rearranged Number",
		url = "https://leetcode.com/problems/smallest-value-of-the-rearranged-number/",
		difficulty = Difficulty.MEDIUM
)
public class SmallestValueOfTheRearrangedNumber {
	public long smallestNumber(long num) {
		if (num == 0) {
			return num;
		}

		boolean negative = false;
		int[] digits = new int[10];
		if (num < 0) {
			negative = true;
			num *= -1;
		}

		for (char ch : String.valueOf(num).toCharArray()) {
			digits[ch - '0']++;
		}

		if (negative) {
			long res = 0;
			for (int i = digits.length - 1; i >= 0; i--) {
				while (digits[i]-- > 0) {
					res *= 10;
					res += i;
				}
			}

			return -1 * res;
		}
		else {
			long res = 0;
			for (int i = 1; i < digits.length; i++) {
				if (digits[i] > 0) {
					res = i;
					digits[i]--;
					break;
				}
			}

			for (int i = 0; i < digits.length; i++) {
				while (digits[i]-- > 0) {
					res *= 10;
					res += i;
				}
			}

			return res;
		}
	}
}
