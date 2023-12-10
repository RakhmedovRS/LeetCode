package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Mar-20
 */
@LeetCode(
		id = 7,
		name = "Reverse Integer",
		url = "https://leetcode.com/problems/reverse-integer/",
		difficulty = Difficulty.MEDIUM
)
public class ReverseInteger {
	public int reverse(int x) {
		long value = 0;
		while (x != 0) {
			value *= 10;
			value += x % 10;
			x /= 10;
		}

		if (Math.abs(value) > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) (value);
	}
}
