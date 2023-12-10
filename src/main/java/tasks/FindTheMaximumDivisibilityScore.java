package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 4/22/2023
 */
@LeetCode(
		id = 2644,
		name = "Find the Maximum Divisibility Score",
		url = "https://leetcode.com/problems/find-the-maximum-divisibility-score/",
		difficulty = Difficulty.EASY
)
public class FindTheMaximumDivisibilityScore {
	public int maxDivScore(int[] nums, int[] divisors) {
		Arrays.sort(divisors);
		int max = 0;
		int div = divisors[0];
		for (int divis : divisors) {
			int curr = 0;
			for (int num : nums) {
				if (num % divis == 0) {
					curr++;
				}
			}

			if (curr > max) {
				max = curr;
				div = divis;
			}
		}

		return div;
	}
}
