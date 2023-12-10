package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/20/2022
 */
@LeetCode(
		id = 2182,
		name = "Construct String With Repeat Limit",
		url = "https://leetcode.com/problems/construct-string-with-repeat-limit/",
		difficulty = Difficulty.MEDIUM
)
public class ConstructStringWithRepeatLimit {
	public String repeatLimitedString(String s, int repeatLimit) {
		int[] freqTable = createCharFrequencyTable(s);
		int unique = 0;
		for (int f : freqTable) {
			if (f > 0) {
				unique++;
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean seen = true;
		boolean useOne = false;
		outer:
		while (seen) {
			seen = false;
			int repeats;
			for (int i = freqTable.length - 1; i >= 0; i--) {
				if (freqTable[i] <= 0) {
					continue;
				}

				seen = true;

				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == (char) (i + 'a')) {
					useOne = true;
					if (unique == 1) {
						break outer;
					}
					continue;
				}

				repeats = 0;
				while (repeats < repeatLimit && freqTable[i]-- > 0) {
					sb.append((char) (i + 'a'));
					repeats++;
					if (freqTable[i] <= 0) {
						unique--;
					}
					if (useOne) {
						useOne = false;
						continue outer;
					}
				}

				if (repeats == repeatLimit) {
					continue outer;
				}
			}
		}

		return sb.toString();
	}

	public int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			if (Character.isAlphabetic(ch)) {
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}
}
