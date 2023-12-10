package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Aug-20
 */
@LeetCode(
		id = 1551,
		name = "Minimum Operations to Make Array Equal",
		url = "https://leetcode.com/problems/minimum-operations-to-make-array-equal/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeArrayEqual {
	public int minOperations(int n) {
		int operations = 0;

		for (int i = 0, j = n - 1; i < j; i++, j--) {
			operations += ((2 * j + 1) - (2 * i + 1)) / 2;
		}

		return operations;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumOperationsToMakeArrayEqual().minOperations(3));
	}
}
