package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 10/14/2023
 */
@LeetCode(
		id = 2900,
		name = "Longest Unequal Adjacent Groups Subsequence I",
		url = "https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/",
		difficulty = Difficulty.MEDIUM
)
public class LongestUnequalAdjacentGroupsSubsequenceI {
	public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
		List<String> zero = new ArrayList<>();
		List<String> one = new ArrayList<>();

		int prev = 1;
		for (int i = 0; i < n; i++) {
			if (groups[i] != prev) {
				zero.add(words[i]);
				prev = groups[i];
			}
		}

		prev = 0;
		for (int i = 0; i < n; i++) {
			if (groups[i] != prev) {
				one.add(words[i]);
				prev = groups[i];
			}
		}

		if (zero.size() >= one.size()) {
			return zero;
		}
		return one;
	}
}
