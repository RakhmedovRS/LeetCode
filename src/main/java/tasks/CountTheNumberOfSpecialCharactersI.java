package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-20
 */
@LeetCode(
		id = 3120,
		name = "Count the Number of Special Characters I",
		url = "https://leetcode.com/problems/count-the-number-of-special-characters-i/description/",
		difficulty = Difficulty.EASY
)
public class CountTheNumberOfSpecialCharactersI {
	public int numberOfSpecialChars(String word) {
		int result = 0;
		char[] chars = word.toCharArray();
		outer:
		for (char ch = 'a'; ch <= 'z'; ch++) {
			boolean seenLower = false;
			boolean seenUpper = false;
			for (char c : chars) {
				if (ch == Character.toLowerCase(c)) {
					if (Character.isUpperCase(c)) {
						seenUpper = true;
					} else {
						seenLower = true;
					}
				}
			}

			if (seenLower && seenUpper) {
				result++;
			}
		}

		return result;
	}
}