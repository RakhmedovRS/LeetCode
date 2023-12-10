package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 8/19/2023
 */
@LeetCode(
		id = 2829,
		name = "Determine the Minimum Sum of a k-avoiding Array",
		url = "https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/",
		difficulty = Difficulty.MEDIUM
)
public class DetermineTheMinimumSumOfKAvoidingArray {
	public int minimumSum(int n, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 1; i <= 1000; i++) {
			set.add(i);
		}

		for (int i = 1; i < (k % 2 == 0 ? k / 2 : k / 2 + 1); i++) {
			set.remove(k - i);
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += set.first();
			set.remove(set.first());
		}

		return sum;
	}
}
