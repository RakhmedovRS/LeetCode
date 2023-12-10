package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/16/2021
 */
@LeetCode(
		id = 1897,
		name = "Redistribute Characters to Make All Strings Equal",
		url = "https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/",
		difficulty = Difficulty.EASY
)
public class RedistributeCharactersToMakeAllStringsEqual {
	public boolean makeEqual(String[] words) {
		int[] memo = new int[26];
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				memo[ch - 'a']++;
			}
		}

		for (int count : memo) {
			if (count % words.length != 0) {
				return false;
			}
		}

		return true;
	}
}
