package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/29/2021
 */
@LeetCode(
		id = 1876,
		name = "Substrings of Size Three with Distinct Characters",
		url = "https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/",
		difficulty = Difficulty.EASY
)
public class SubstringsOfSizeThreeWithDistinctCharacters {
	public int countGoodSubstrings(String s) {
		if (s.length() < 3) {
			return 0;
		}

		int count = 0;
		int[] table = new int[26];
		outer:
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
			if (i >= 3) {
				table[s.charAt(i - 3) - 'a']--;
			}

			if (i >= 2) {
				for (int j = 0; j < 26; j++) {
					if (table[j] > 1) {
						continue outer;
					}
				}

				count++;
			}
		}

		return count;
	}
}
