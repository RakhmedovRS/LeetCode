package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/30/2020
 */
@LeetCode(
		id = 1085,
		name = "Sum of Digits in the Minimum Number",
		url = "https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class SumOfDigitsInTheMinimumNumber {
	public int sumOfDigits(int[] A) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int num : A) {
			min = Math.min(min, num);
		}

		while (min > 0) {
			sum += min % 10;
			min /= 10;
		}

		return sum % 2 == 0 ? 1 : 0;
	}
}
