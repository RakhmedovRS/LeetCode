package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/2/2021
 */
@LeetCode(
		id = 2023,
		name = "Number of Pairs of Strings With Concatenation Equal to Target",
		url = "https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
	public int numOfPairs(String[] nums, String target) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j) {
					continue;
				}

				if (target.equals(nums[i] + nums[j])) {
					count++;
				}
			}
		}

		return count;
	}
}
