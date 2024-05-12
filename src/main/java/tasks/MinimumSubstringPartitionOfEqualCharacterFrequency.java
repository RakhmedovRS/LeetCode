package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-11
 */
@LeetCode(
		id = 3144,
		name = "Minimum Substring Partition of Equal Character Frequency",
		url = "https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumSubstringPartitionOfEqualCharacterFrequency {
	public int minimumSubstringsInPartition(String s) {
		return dfs(0, s.toCharArray(), new Integer[s.length() + 1]);
	}

	private int dfs(int start, char[] chars, Integer[] memo) {
		if (start >= chars.length) {
			return 0;
		}

		if (memo[start] != null) {
			return memo[start];
		}

		int[] freqTable = new int[26];

		int min = Integer.MAX_VALUE;
		int pos = start;
		while (pos < chars.length) {
			freqTable[chars[pos++] - 'a']++;
			if (isValid(freqTable)) {
				int res = dfs(pos, chars, memo);
				if (res != -1) {
					min = Math.min(min, res + 1);
				}
			}
		}

		memo[start] = min;

		return min;
	}

	private boolean isValid(int[] freqTable) {
		Integer prev = null;
		for (int f : freqTable) {
			if (f > 0) {
				if (prev == null) {
					prev = f;
				} else {
					if (f != prev) {
						return false;
					}
				}
			}
		}

		return true;
	}
}