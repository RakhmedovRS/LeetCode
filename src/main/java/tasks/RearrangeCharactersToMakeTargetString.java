package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/12/2022
 */
@LeetCode(
		id = 2287,
		name = "Rearrange Characters to Make Target String",
		url = "https://leetcode.com/problems/rearrange-characters-to-make-target-string/",
		difficulty = Difficulty.EASY
)
public class RearrangeCharactersToMakeTargetString {
	public int rearrangeCharacters(String s, String target) {
		int[] sTable = createCharFrequencyTable(s);
		int[] targetTable = createCharFrequencyTable(target);

		int max = Integer.MAX_VALUE;
		for (int i = 0; i < targetTable.length; i++) {
			if (targetTable[i] > 0) {
				max = Math.min(max, sTable[i] / targetTable[i]);
			}
		}

		return max;
	}

	private int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}
}
