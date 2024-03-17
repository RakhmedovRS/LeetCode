package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/16/2024
 */
@LeetCode(
		id = 3085,
		name = "Minimum Deletions to Make String K-Special",
		url = "https://leetcode.com/problems/minimum-deletions-to-make-string-k-special/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumDeletionsToMakeStringKSpecial {
	public int minimumDeletions(String word, int k) {
		int[] freqTable = createCharFrequencyTable(word);
		int maxValue = 0;
		for (int f : freqTable) {
			maxValue = Math.max(maxValue, f);
		}

		int minOps = Integer.MAX_VALUE;
		for (int left = 1, right = k + 1; left <= maxValue; left++, right++) {
			int ops = 0;

			for (int f : freqTable) {
				if (f == 0) {
					continue;
				}

				if (f < left) {
					ops += f;
				} else if (f > right) {
					ops += f - right;
				}
			}

			minOps = Math.min(minOps, ops);
		}

		return minOps;
	}

	public static int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}
}
