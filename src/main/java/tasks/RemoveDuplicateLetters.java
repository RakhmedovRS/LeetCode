package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(
		id = 316,
		name = "Remove Duplicate Letters",
		url = "https://leetcode.com/problems/remove-duplicate-letters/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] table = new int[26];
		char[] chars = s.toCharArray();
		for (char ch : chars) {
			table[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		boolean found;
		for (char ch : chars) {
			if (table[ch - 'a'] == 0) {
				continue;
			}

			if (table[ch - 'a'] == 1) {
				for (int i = 0; i < ch - 'a'; i++) {
					if (table[i] != 0) {
						sb.append((char) (i + 'a'));
						table[i] = 0;
					}
				}

				sb.append(ch);
				table[ch - 'a'] = 0;
				continue;
			}
			table[ch - 'a']--;
		}

		return sb.toString();
	}
}
