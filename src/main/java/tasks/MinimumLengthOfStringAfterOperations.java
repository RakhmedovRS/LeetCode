package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-20
 */
@LeetCode(
		id = 3223,
		name = "Minimum Length of String After Operations",
		url = "https://leetcode.com/problems/minimum-length-of-string-after-operations/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumLengthOfStringAfterOperations {
	public int minimumLength(String s) {
		int[] freqTable = createCharFrequencyTable(s);
		int ans = 0;
		for (int i = 0; i < freqTable.length; i++) {
			while (freqTable[i] > 2) {
				freqTable[i] -= 2;
			}
			ans += freqTable[i];
		}
		return ans;
	}

	public static int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[ch - 'a']++;
			}
		}
		return pattern;
	}
}