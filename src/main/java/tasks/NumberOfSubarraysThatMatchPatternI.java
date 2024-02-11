package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-10
 */
@LeetCode(
		id = 3034,
		name = "Number of Subarrays That Match a Pattern I",
		url = "https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfSubarraysThatMatchPatternI {
	public int countMatchingSubarrays(int[] nums, int[] pattern) {
		int ans = 0;
		outer:
		for (int i = 0; i < nums.length - pattern.length; i++) {
			for (int j = i, p = 0; p < pattern.length; j++, p++) {
				if (pattern[p] == 1) {
					if (nums[j] >= nums[j + 1]) {
						continue outer;
					}
				} else if (pattern[p] == -1) {
					if (nums[j] <= nums[j + 1]) {
						continue outer;
					}
				} else {
					if (nums[j] != nums[j + 1]) {
						continue outer;
					}
				}
			}

			ans++;
		}

		return ans;
	}
}