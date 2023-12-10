package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
		id = 1657,
		name = "Determine if Two Strings Are Close",
		url = "https://leetcode.com/problems/determine-if-two-strings-are-close/",
		difficulty = Difficulty.MEDIUM
)
public class DetermineIfTwoStringsAreClose {
	public boolean closeStrings(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}

		int[] tableA = new int[26];
		for (char ch : word1.toCharArray()) {
			tableA[ch - 'a']++;
		}

		int[] tableB = new int[26];
		for (char ch : word2.toCharArray()) {
			tableB[ch - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if ((tableA[i] == 0 && tableB[i] != 0) || (tableB[i] == 0 && tableA[i] != 0)) {
				return false;
			}
		}

		Arrays.sort(tableA);
		Arrays.sort(tableB);

		for (int i = 0; i < 26; i++) {
			if (tableA[i] != tableB[i]) {
				return false;
			}
		}

		return true;
	}
}
