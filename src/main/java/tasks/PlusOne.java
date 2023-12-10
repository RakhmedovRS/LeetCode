package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Mar-20
 */
@LeetCode(
		id = 66,
		name = "Plus One",
		url = "https://leetcode.com/problems/plus-one/",
		difficulty = Difficulty.EASY
)
public class PlusOne {
	public int[] plusOne(int[] digits) {
		boolean inPlace = false;
		for (int digit : digits) {
			if (digit != 9) {
				inPlace = true;
				break;
			}
		}

		if (!inPlace) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
		else {
			int add = 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				if (digits[i] + add >= 10) {
					digits[i] = 0;
				}
				else {
					digits[i] += 1;
					break;
				}
			}

			return digits;
		}
	}
}
