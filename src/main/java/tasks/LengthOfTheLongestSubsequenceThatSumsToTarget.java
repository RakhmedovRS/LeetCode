package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 10/28/2023
 */
@LeetCode(
		id = 2915,
		name = "Length of the Longest Subsequence That Sums to Target",
		url = "https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/",
		difficulty = Difficulty.MEDIUM
)
public class LengthOfTheLongestSubsequenceThatSumsToTarget {
	public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
		Integer[] memo = new Integer[target + 1];
		memo[0] = 0;
		for (Integer num : nums) {
			Integer[] nextMemo = new Integer[target + 1];
			System.arraycopy(memo, 0, nextMemo, 0, memo.length);

			for (int i = 0; i < memo.length; i++) {
				if (memo[i] != null) {
					int val = i + num;
					if (val >= memo.length) {
						break;
					}

					if (memo[val] != null) {
						nextMemo[val] = Math.max(memo[val], memo[i] + 1);
					}
					else {
						nextMemo[val] = memo[i] + 1;
					}
				}
			}

			memo = nextMemo;
		}

		return memo[target] == null ? -1 : memo[target];
	}
}
