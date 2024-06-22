package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-22
 */
@LeetCode(
		id = 3190,
		name = "Find Minimum Operations to Make All Elements Divisible by Three",
		url = "https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/",
		difficulty = Difficulty.EASY
)
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
	public int minimumOperations(int[] nums) {
		int ops = 0;
		for (int num : nums) {
			if (num % 3 != 0) {
				ops++;
			}
		}
		return ops;
	}
}