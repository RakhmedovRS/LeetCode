package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
		id = 1228,
		name = "Missing Number In Arithmetic Progression",
		url = "https://leetcode.com/problems/missing-number-in-arithmetic-progression/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class MissingNumberInArithmeticProgression {
	public int missingNumber(int[] arr) {
		int diff = arr[1] - arr[0];
		Integer missing = null;
		int i = 2;
		for (; i < arr.length; i++) {
			if (arr[i - 1] + diff != arr[i]) {
				if (missing == null) {
					missing = arr[i - 1] + diff;
					if (missing + diff != arr[i]) {
						break;
					}
				}
			}
		}

		if (i == arr.length) {
			return missing == null ? arr[0] : missing;
		}

		diff = arr[arr.length - 2] - arr[arr.length - 1];
		i = arr.length - 2;
		for (; i > 0; i--) {
			if (arr[i] + diff != arr[i - 1]) {
				missing = arr[i] + diff;
				break;
			}
		}

		return missing == null ? arr[0] : missing;
	}

	public static void main(String[] args) {
		MissingNumberInArithmeticProgression clazz = new MissingNumberInArithmeticProgression();
		System.out.println(clazz.missingNumber(new int[]{1, 2, 3, 5}));
		System.out.println(clazz.missingNumber(new int[]{5, 7, 11, 13}));
	}
}
