package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/1/2022
 */
@LeetCode(
		id = 2455,
		name = "Average Value of Even Numbers That Are Divisible by Three",
		url = "https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/",
		difficulty = Difficulty.EASY
)
public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
	public int averageValue(int[] nums) {
		int sum = 0;
		int count = 0;
		for (int num : nums) {
			if (num % 3 == 0 && num % 2 == 0) {
				sum += num;
				count++;
			}
		}


		return count == 0 ? 0 : sum / count;
	}
}
