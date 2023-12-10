package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/26/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2351,
		name = "First Letter to Appear Twice",
		url = "https://leetcode.com/problems/first-letter-to-appear-twice/",
		difficulty = Difficulty.EASY
)
public class FirstLetterToAppearTwice {
	public char repeatedCharacter(String s) {
		char[] memo = new char[26];
		for (char ch : s.toCharArray()) {
			memo[ch - 'a']++;
			if (memo[ch - 'a'] == 2) {
				return ch;
			}
		}

		return ' ';
	}
}
