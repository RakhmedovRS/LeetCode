package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/25/2023
 */
@LeetCode(
		id = 2652,
		name = "Sum Multiples",
		url = "https://leetcode.com/problems/sum-multiples/",
		difficulty = Difficulty.EASY
)
public class SumMultiples {
	public int sumOfMultiples(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
